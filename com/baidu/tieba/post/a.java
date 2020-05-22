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
    private static com.baidu.adp.widget.ImageView.a ktO;
    private static String ktP;
    public TextView agw;
    public TextView dVT;
    public TextView dWR;
    private final LinearLayout iMP;
    private final LinearLayout jtG;
    private InterfaceC0705a kDA;
    protected final LinearLayout ktL;
    protected final ColumnLayout ktM;
    protected final ColumnLayout ktN;
    private int ktQ;
    public LinearLayout ktR;
    public HeadImageView ktS;
    public TextView ktT;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0705a {
        void cV(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ktR = (LinearLayout) view.findViewById(R.id.top_line);
        this.ktS = (HeadImageView) view.findViewById(R.id.portrait);
        this.agw = (TextView) view.findViewById(R.id.username);
        this.dVT = (TextView) view.findViewById(R.id.reply_time);
        this.dWR = (TextView) view.findViewById(R.id.forum_name);
        this.ktT = (TextView) view.findViewById(R.id.reply_count);
        this.jtG = (LinearLayout) view.findViewById(R.id.item_content);
        this.ktM = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ktN = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.iMP = (LinearLayout) view.findViewById(R.id.person_thread);
        this.ktL = (LinearLayout) view.findViewById(R.id.person_child);
        this.ktQ = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.jtG != null) {
            this.jtG.setOnClickListener(this);
        }
        this.ktS.setOnClickListener(this);
        this.agw.setOnClickListener(this);
        this.dWR.setOnClickListener(this);
        this.ktT.setOnClickListener(this);
        this.ktM.setOnClickListener(this);
        this.ktN.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.kDA != null) {
            this.kDA.cV(view);
        }
    }

    public void a(InterfaceC0705a interfaceC0705a) {
        this.kDA = interfaceC0705a;
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
            this.agw.setText(str2);
            this.dVT.setText(str3);
            this.dWR.setText(str4);
            this.dWR.setTag(str4);
            this.ktT.setText(str5);
            this.ktT.setTag(strArr);
            this.dWR.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                Ks(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                Ks(str);
            }
            if (this.jtG != null) {
                this.jtG.setTag(strArr);
            }
            this.ktM.setTag(strArr);
            this.ktN.setTag(strArr);
        }
    }

    private void Ks(String str) {
        if (ktP != null && !ktP.equals(str)) {
            ktO = null;
        }
        if (ktO != null) {
            this.ktS.setImageBitmap(ktO.getRawBitmap());
            ktP = str;
            return;
        }
        this.ktS.a(str, 12, this.ktQ, this.ktQ, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.dWR, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dVT, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.agw, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.iMP, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.ktL, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.ktT.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.ktT, R.color.cp_link_tip_c, 1);
    }
}
