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
    private static com.baidu.adp.widget.ImageView.a jrD;
    private static String jrE;
    public TextView Nm;
    public TextView dhF;
    public TextView diF;
    public HeadImageView gJL;
    private final LinearLayout iuu;
    private InterfaceC0592a jBw;
    protected final LinearLayout jrA;
    protected final ColumnLayout jrB;
    protected final ColumnLayout jrC;
    private int jrF;
    public LinearLayout jrG;
    public TextView jrH;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0592a {
        void cM(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jrG = (LinearLayout) view.findViewById(R.id.top_line);
        this.gJL = (HeadImageView) view.findViewById(R.id.portrait);
        this.Nm = (TextView) view.findViewById(R.id.username);
        this.dhF = (TextView) view.findViewById(R.id.reply_time);
        this.diF = (TextView) view.findViewById(R.id.forum_name);
        this.jrH = (TextView) view.findViewById(R.id.reply_count);
        this.iuu = (LinearLayout) view.findViewById(R.id.item_content);
        this.jrB = (ColumnLayout) view.findViewById(R.id.item_header);
        this.jrC = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.jrA = (LinearLayout) view.findViewById(R.id.person_child);
        this.jrF = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.iuu != null) {
            this.iuu.setOnClickListener(this);
        }
        this.gJL.setOnClickListener(this);
        this.Nm.setOnClickListener(this);
        this.diF.setOnClickListener(this);
        this.jrH.setOnClickListener(this);
        this.jrB.setOnClickListener(this);
        this.jrC.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.jBw != null) {
            this.jBw.cM(view);
        }
    }

    public void a(InterfaceC0592a interfaceC0592a) {
        this.jBw = interfaceC0592a;
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
            this.Nm.setText(str2);
            this.dhF.setText(str3);
            this.diF.setText(str4);
            this.diF.setTag(str4);
            this.jrH.setText(str5);
            this.jrH.setTag(strArr);
            this.diF.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                GV(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                GV(str);
            }
            if (this.iuu != null) {
                this.iuu.setTag(strArr);
            }
            this.jrB.setTag(strArr);
            this.jrC.setTag(strArr);
        }
    }

    private void GV(String str) {
        if (jrE != null && !jrE.equals(str)) {
            jrD = null;
        }
        if (jrD != null) {
            this.gJL.setImageBitmap(jrD.getRawBitmap());
            jrE = str;
            return;
        }
        this.gJL.a(str, 12, this.jrF, this.jrF, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.diF, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dhF, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.Nm, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.mLayout, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.jrA, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.jrH.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.jrH, R.color.cp_link_tip_c, 1);
    }
}
