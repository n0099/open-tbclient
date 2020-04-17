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
    private static com.baidu.adp.widget.ImageView.a kbS;
    private static String kbT;
    public TextView afW;
    public TextView dHA;
    public TextView dIy;
    private final LinearLayout jez;
    protected final LinearLayout kbP;
    protected final ColumnLayout kbQ;
    protected final ColumnLayout kbR;
    private int kbU;
    public LinearLayout kbV;
    public HeadImageView kbW;
    public TextView kbX;
    private InterfaceC0631a klB;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0631a {
        void cU(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.kbV = (LinearLayout) view.findViewById(R.id.top_line);
        this.kbW = (HeadImageView) view.findViewById(R.id.portrait);
        this.afW = (TextView) view.findViewById(R.id.username);
        this.dHA = (TextView) view.findViewById(R.id.reply_time);
        this.dIy = (TextView) view.findViewById(R.id.forum_name);
        this.kbX = (TextView) view.findViewById(R.id.reply_count);
        this.jez = (LinearLayout) view.findViewById(R.id.item_content);
        this.kbQ = (ColumnLayout) view.findViewById(R.id.item_header);
        this.kbR = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.kbP = (LinearLayout) view.findViewById(R.id.person_child);
        this.kbU = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.jez != null) {
            this.jez.setOnClickListener(this);
        }
        this.kbW.setOnClickListener(this);
        this.afW.setOnClickListener(this);
        this.dIy.setOnClickListener(this);
        this.kbX.setOnClickListener(this);
        this.kbQ.setOnClickListener(this);
        this.kbR.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.klB != null) {
            this.klB.cU(view);
        }
    }

    public void a(InterfaceC0631a interfaceC0631a) {
        this.klB = interfaceC0631a;
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
            this.afW.setText(str2);
            this.dHA.setText(str3);
            this.dIy.setText(str4);
            this.dIy.setTag(str4);
            this.kbX.setText(str5);
            this.kbX.setTag(strArr);
            this.dIy.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                ID(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                ID(str);
            }
            if (this.jez != null) {
                this.jez.setTag(strArr);
            }
            this.kbQ.setTag(strArr);
            this.kbR.setTag(strArr);
        }
    }

    private void ID(String str) {
        if (kbT != null && !kbT.equals(str)) {
            kbS = null;
        }
        if (kbS != null) {
            this.kbW.setImageBitmap(kbS.getRawBitmap());
            kbT = str;
            return;
        }
        this.kbW.a(str, 12, this.kbU, this.kbU, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.dIy, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dHA, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.afW, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.mLayout, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.kbP, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.kbX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.kbX, R.color.cp_link_tip_c, 1);
    }
}
