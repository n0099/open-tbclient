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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a jlm;
    private static String jln;
    public TextView ME;
    public TextView dcP;
    public TextView ddN;
    public HeadImageView gDe;
    private final LinearLayout ing;
    protected final LinearLayout jlj;
    protected final ColumnLayout jlk;
    protected final ColumnLayout jll;
    private int jlo;
    public LinearLayout jlp;
    public TextView jlq;
    private InterfaceC0578a jvm;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0578a {
        void cF(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jlp = (LinearLayout) view.findViewById(R.id.top_line);
        this.gDe = (HeadImageView) view.findViewById(R.id.portrait);
        this.ME = (TextView) view.findViewById(R.id.username);
        this.dcP = (TextView) view.findViewById(R.id.reply_time);
        this.ddN = (TextView) view.findViewById(R.id.forum_name);
        this.jlq = (TextView) view.findViewById(R.id.reply_count);
        this.ing = (LinearLayout) view.findViewById(R.id.item_content);
        this.jlk = (ColumnLayout) view.findViewById(R.id.item_header);
        this.jll = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.jlj = (LinearLayout) view.findViewById(R.id.person_child);
        this.jlo = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.ing != null) {
            this.ing.setOnClickListener(this);
        }
        this.gDe.setOnClickListener(this);
        this.ME.setOnClickListener(this);
        this.ddN.setOnClickListener(this);
        this.jlq.setOnClickListener(this);
        this.jlk.setOnClickListener(this);
        this.jll.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.jvm != null) {
            this.jvm.cF(view);
        }
    }

    public void a(InterfaceC0578a interfaceC0578a) {
        this.jvm = interfaceC0578a;
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
            this.ME.setText(str2);
            this.dcP.setText(str3);
            this.ddN.setText(str4);
            this.ddN.setTag(str4);
            this.jlq.setText(str5);
            this.ddN.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                Gx(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                Gx(str);
            }
            if (this.ing != null) {
                this.ing.setTag(strArr);
            }
            this.jlk.setTag(strArr);
            this.jll.setTag(strArr);
        }
    }

    private void Gx(String str) {
        if (jln != null && !jln.equals(str)) {
            jlm = null;
        }
        if (jlm != null) {
            this.gDe.setImageBitmap(jlm.getRawBitmap());
            jln = str;
            return;
        }
        this.gDe.a(str, 12, this.jlo, this.jlo, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.ddN, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dcP, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.ME, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.mLayout, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.jlj, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.jlq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.jlq, R.color.cp_link_tip_c, 1);
    }
}
