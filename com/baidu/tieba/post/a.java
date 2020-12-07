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
/* loaded from: classes24.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a mtl;
    private static String mtm;
    public TextView aky;
    public TextView fcE;
    public TextView fdz;
    private final LinearLayout kGg;
    private final LinearLayout loa;
    private InterfaceC0846a mBB;
    private TbPageContext<?> mPageContext;
    protected final LinearLayout mti;
    protected final ColumnLayout mtj;
    protected final ColumnLayout mtk;
    private int mtn;
    public LinearLayout mto;
    public HeadImageView mtp;
    public TextView mtq;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0846a {
        void dQ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mto = (LinearLayout) view.findViewById(R.id.top_line);
        this.mtp = (HeadImageView) view.findViewById(R.id.portrait);
        this.aky = (TextView) view.findViewById(R.id.username);
        this.fcE = (TextView) view.findViewById(R.id.reply_time);
        this.fdz = (TextView) view.findViewById(R.id.forum_name);
        this.mtq = (TextView) view.findViewById(R.id.reply_count);
        this.loa = (LinearLayout) view.findViewById(R.id.item_content);
        this.mtj = (ColumnLayout) view.findViewById(R.id.item_header);
        this.mtk = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.kGg = (LinearLayout) view.findViewById(R.id.person_thread);
        this.mti = (LinearLayout) view.findViewById(R.id.person_child);
        this.mtn = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.loa != null) {
            this.loa.setOnClickListener(this);
        }
        this.mtp.setOnClickListener(this);
        this.aky.setOnClickListener(this);
        this.fdz.setOnClickListener(this);
        this.mtq.setOnClickListener(this);
        this.mtj.setOnClickListener(this);
        this.mtk.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.mBB != null) {
            this.mBB.dQ(view);
        }
    }

    public void a(InterfaceC0846a interfaceC0846a) {
        this.mBB = interfaceC0846a;
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
            this.aky.setText(str2);
            this.fcE.setText(str3);
            this.fdz.setText(str4);
            this.fdz.setTag(str4);
            this.mtq.setText(str5);
            this.mtq.setTag(strArr);
            this.fdz.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                Rl(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                Rl(str);
            }
            if (this.loa != null) {
                this.loa.setTag(strArr);
            }
            this.mtj.setTag(strArr);
            this.mtk.setTag(strArr);
        }
    }

    private void Rl(String str) {
        if (mtm != null && !mtm.equals(str)) {
            mtl = null;
        }
        if (mtl != null) {
            this.mtp.setImageBitmap(mtl.getRawBitmap());
            mtm = str;
            return;
        }
        this.mtp.a(str, 12, this.mtn, this.mtn, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.fdz, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.fcE, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.aky, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.kGg, R.color.CAM_X0204);
        ap.setBackgroundResource(this.mti, R.color.CAM_X0201);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.mtq.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.mtq, R.color.CAM_X0304, 1);
    }
}
