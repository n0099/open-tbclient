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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a jpS;
    private static String jpT;
    public TextView Nl;
    public TextView dhf;
    public TextView dic;
    public HeadImageView gIu;
    private final LinearLayout isI;
    protected final LinearLayout jpP;
    protected final ColumnLayout jpQ;
    protected final ColumnLayout jpR;
    private int jpU;
    public LinearLayout jpV;
    public TextView jpW;
    private InterfaceC0591a jzL;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0591a {
        void cM(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jpV = (LinearLayout) view.findViewById(R.id.top_line);
        this.gIu = (HeadImageView) view.findViewById(R.id.portrait);
        this.Nl = (TextView) view.findViewById(R.id.username);
        this.dhf = (TextView) view.findViewById(R.id.reply_time);
        this.dic = (TextView) view.findViewById(R.id.forum_name);
        this.jpW = (TextView) view.findViewById(R.id.reply_count);
        this.isI = (LinearLayout) view.findViewById(R.id.item_content);
        this.jpQ = (ColumnLayout) view.findViewById(R.id.item_header);
        this.jpR = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.jpP = (LinearLayout) view.findViewById(R.id.person_child);
        this.jpU = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.isI != null) {
            this.isI.setOnClickListener(this);
        }
        this.gIu.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.dic.setOnClickListener(this);
        this.jpW.setOnClickListener(this);
        this.jpQ.setOnClickListener(this);
        this.jpR.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.jzL != null) {
            this.jzL.cM(view);
        }
    }

    public void a(InterfaceC0591a interfaceC0591a) {
        this.jzL = interfaceC0591a;
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
                str3 = aq.getFormatTime(postInfoList.create_time * 1000);
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
                str3 = aq.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.Nl.setText(str2);
            this.dhf.setText(str3);
            this.dic.setText(str4);
            this.dic.setTag(str4);
            this.jpW.setText(str5);
            this.jpW.setTag(strArr);
            this.dic.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                GV(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                GV(str);
            }
            if (this.isI != null) {
                this.isI.setTag(strArr);
            }
            this.jpQ.setTag(strArr);
            this.jpR.setTag(strArr);
        }
    }

    private void GV(String str) {
        if (jpT != null && !jpT.equals(str)) {
            jpS = null;
        }
        if (jpS != null) {
            this.gIu.setImageBitmap(jpS.getRawBitmap());
            jpT = str;
            return;
        }
        this.gIu.a(str, 12, this.jpU, this.jpU, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.dic, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dhf, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.Nl, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.mLayout, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.jpP, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.jpW.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.jpW, R.color.cp_link_tip_c, 1);
    }
}
