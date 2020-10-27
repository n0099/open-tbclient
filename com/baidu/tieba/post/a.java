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
    private static com.baidu.adp.widget.ImageView.a lYN;
    private static String lYO;
    public TextView aju;
    public TextView eQj;
    public TextView eRg;
    private final LinearLayout kUo;
    private final LinearLayout kmf;
    protected final LinearLayout lYK;
    protected final ColumnLayout lYL;
    protected final ColumnLayout lYM;
    private int lYP;
    public LinearLayout lYQ;
    public HeadImageView lYR;
    public TextView lYS;
    private TbPageContext<?> mPageContext;
    private InterfaceC0813a mhf;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0813a {
        void dw(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.lYQ = (LinearLayout) view.findViewById(R.id.top_line);
        this.lYR = (HeadImageView) view.findViewById(R.id.portrait);
        this.aju = (TextView) view.findViewById(R.id.username);
        this.eQj = (TextView) view.findViewById(R.id.reply_time);
        this.eRg = (TextView) view.findViewById(R.id.forum_name);
        this.lYS = (TextView) view.findViewById(R.id.reply_count);
        this.kUo = (LinearLayout) view.findViewById(R.id.item_content);
        this.lYL = (ColumnLayout) view.findViewById(R.id.item_header);
        this.lYM = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.kmf = (LinearLayout) view.findViewById(R.id.person_thread);
        this.lYK = (LinearLayout) view.findViewById(R.id.person_child);
        this.lYP = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.kUo != null) {
            this.kUo.setOnClickListener(this);
        }
        this.lYR.setOnClickListener(this);
        this.aju.setOnClickListener(this);
        this.eRg.setOnClickListener(this);
        this.lYS.setOnClickListener(this);
        this.lYL.setOnClickListener(this);
        this.lYM.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.mhf != null) {
            this.mhf.dw(view);
        }
    }

    public void a(InterfaceC0813a interfaceC0813a) {
        this.mhf = interfaceC0813a;
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
            this.aju.setText(str2);
            this.eQj.setText(str3);
            this.eRg.setText(str4);
            this.eRg.setTag(str4);
            this.lYS.setText(str5);
            this.lYS.setTag(strArr);
            this.eRg.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                Qq(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                Qq(str);
            }
            if (this.kUo != null) {
                this.kUo.setTag(strArr);
            }
            this.lYL.setTag(strArr);
            this.lYM.setTag(strArr);
        }
    }

    private void Qq(String str) {
        if (lYO != null && !lYO.equals(str)) {
            lYN = null;
        }
        if (lYN != null) {
            this.lYR.setImageBitmap(lYN.getRawBitmap());
            lYO = str;
            return;
        }
        this.lYR.a(str, 12, this.lYP, this.lYP, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.eRg, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.eQj, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.aju, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.kmf, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.lYK, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.lYS.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.lYS, R.color.cp_link_tip_c, 1);
    }
}
