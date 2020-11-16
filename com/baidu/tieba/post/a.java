package com.baidu.tieba.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes23.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a mff;
    private static String mfg;
    public TextView ajz;
    public TextView eVh;
    public TextView eWc;
    private final LinearLayout ksL;
    private final LinearLayout laE;
    private TbPageContext<?> mPageContext;
    protected final LinearLayout mfc;
    protected final ColumnLayout mfd;
    protected final ColumnLayout mfe;
    private int mfh;
    public LinearLayout mfi;
    public HeadImageView mfj;
    public TextView mfk;
    private InterfaceC0830a mnx;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0830a {
        void dF(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mfi = (LinearLayout) view.findViewById(R.id.top_line);
        this.mfj = (HeadImageView) view.findViewById(R.id.portrait);
        this.ajz = (TextView) view.findViewById(R.id.username);
        this.eVh = (TextView) view.findViewById(R.id.reply_time);
        this.eWc = (TextView) view.findViewById(R.id.forum_name);
        this.mfk = (TextView) view.findViewById(R.id.reply_count);
        this.laE = (LinearLayout) view.findViewById(R.id.item_content);
        this.mfd = (ColumnLayout) view.findViewById(R.id.item_header);
        this.mfe = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.ksL = (LinearLayout) view.findViewById(R.id.person_thread);
        this.mfc = (LinearLayout) view.findViewById(R.id.person_child);
        this.mfh = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.laE != null) {
            this.laE.setOnClickListener(this);
        }
        this.mfj.setOnClickListener(this);
        this.ajz.setOnClickListener(this);
        this.eWc.setOnClickListener(this);
        this.mfk.setOnClickListener(this);
        this.mfd.setOnClickListener(this);
        this.mfe.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.mnx != null) {
            this.mnx.dF(view);
        }
    }

    public void a(InterfaceC0830a interfaceC0830a) {
        this.mnx = interfaceC0830a;
    }

    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        boolean z2;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String[] strArr = new String[4];
        try {
            if (z) {
                z2 = true;
                str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.post_id);
                str3 = au.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
                strArr[3] = String.valueOf(postInfoList.thread_type);
            } else {
                z2 = true;
                str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                strArr[3] = String.valueOf(postInfoList.thread_type);
                str3 = au.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.ajz.setText(str2);
            this.eVh.setText(str3);
            this.eWc.setText(str4);
            this.eWc.setTag(str4);
            this.mfk.setText(str5);
            this.mfk.setTag(strArr);
            this.eWc.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                Qc(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                Qc(str);
            }
            if (this.laE != null) {
                this.laE.setTag(strArr);
            }
            this.mfd.setTag(strArr);
            this.mfe.setTag(strArr);
        }
    }

    private void Qc(String str) {
        if (mfg != null && !mfg.equals(str)) {
            mff = null;
        }
        if (mff != null) {
            this.mfj.setImageBitmap(mff.getRawBitmap());
            mfg = str;
            return;
        }
        this.mfj.a(str, 12, this.mfh, this.mfh, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.eWc, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.eVh, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.ajz, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.ksL, R.color.CAM_X0204);
        ap.setBackgroundResource(this.mfc, R.color.CAM_X0201);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.mfk.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.mfk, R.color.CAM_X0304, 1);
    }
}
