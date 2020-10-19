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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes24.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a lMr;
    private static String lMs;
    public TextView ajt;
    public TextView eHN;
    public TextView eIK;
    private final LinearLayout jZF;
    private final LinearLayout kHR;
    protected final LinearLayout lMo;
    protected final ColumnLayout lMp;
    protected final ColumnLayout lMq;
    private int lMt;
    public LinearLayout lMu;
    public HeadImageView lMv;
    public TextView lMw;
    private InterfaceC0798a lUG;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0798a {
        void ds(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.lMu = (LinearLayout) view.findViewById(R.id.top_line);
        this.lMv = (HeadImageView) view.findViewById(R.id.portrait);
        this.ajt = (TextView) view.findViewById(R.id.username);
        this.eHN = (TextView) view.findViewById(R.id.reply_time);
        this.eIK = (TextView) view.findViewById(R.id.forum_name);
        this.lMw = (TextView) view.findViewById(R.id.reply_count);
        this.kHR = (LinearLayout) view.findViewById(R.id.item_content);
        this.lMp = (ColumnLayout) view.findViewById(R.id.item_header);
        this.lMq = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.jZF = (LinearLayout) view.findViewById(R.id.person_thread);
        this.lMo = (LinearLayout) view.findViewById(R.id.person_child);
        this.lMt = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.kHR != null) {
            this.kHR.setOnClickListener(this);
        }
        this.lMv.setOnClickListener(this);
        this.ajt.setOnClickListener(this);
        this.eIK.setOnClickListener(this);
        this.lMw.setOnClickListener(this);
        this.lMp.setOnClickListener(this);
        this.lMq.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.lUG != null) {
            this.lUG.ds(view);
        }
    }

    public void a(InterfaceC0798a interfaceC0798a) {
        this.lUG = interfaceC0798a;
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
                str3 = at.getFormatTime(postInfoList.create_time * 1000);
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
                str3 = at.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.ajt.setText(str2);
            this.eHN.setText(str3);
            this.eIK.setText(str4);
            this.eIK.setTag(str4);
            this.lMw.setText(str5);
            this.lMw.setTag(strArr);
            this.eIK.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                PS(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                PS(str);
            }
            if (this.kHR != null) {
                this.kHR.setTag(strArr);
            }
            this.lMp.setTag(strArr);
            this.lMq.setTag(strArr);
        }
    }

    private void PS(String str) {
        if (lMs != null && !lMs.equals(str)) {
            lMr = null;
        }
        if (lMr != null) {
            this.lMv.setImageBitmap(lMr.getRawBitmap());
            lMs = str;
            return;
        }
        this.lMv.a(str, 12, this.lMt, this.lMt, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.eIK, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.eHN, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.ajt, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.jZF, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.lMo, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.lMw.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.lMw, R.color.cp_link_tip_c, 1);
    }
}
