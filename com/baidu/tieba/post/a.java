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
    private static com.baidu.adp.widget.ImageView.a kbW;
    private static String kbX;
    public TextView afZ;
    public TextView dHE;
    public TextView dIC;
    private final LinearLayout jeD;
    protected final LinearLayout kbT;
    protected final ColumnLayout kbU;
    protected final ColumnLayout kbV;
    private int kbY;
    public LinearLayout kbZ;
    public HeadImageView kca;
    public TextView kcb;
    private InterfaceC0652a klF;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0652a {
        void cU(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.kbZ = (LinearLayout) view.findViewById(R.id.top_line);
        this.kca = (HeadImageView) view.findViewById(R.id.portrait);
        this.afZ = (TextView) view.findViewById(R.id.username);
        this.dHE = (TextView) view.findViewById(R.id.reply_time);
        this.dIC = (TextView) view.findViewById(R.id.forum_name);
        this.kcb = (TextView) view.findViewById(R.id.reply_count);
        this.jeD = (LinearLayout) view.findViewById(R.id.item_content);
        this.kbU = (ColumnLayout) view.findViewById(R.id.item_header);
        this.kbV = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.kbT = (LinearLayout) view.findViewById(R.id.person_child);
        this.kbY = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.jeD != null) {
            this.jeD.setOnClickListener(this);
        }
        this.kca.setOnClickListener(this);
        this.afZ.setOnClickListener(this);
        this.dIC.setOnClickListener(this);
        this.kcb.setOnClickListener(this);
        this.kbU.setOnClickListener(this);
        this.kbV.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.klF != null) {
            this.klF.cU(view);
        }
    }

    public void a(InterfaceC0652a interfaceC0652a) {
        this.klF = interfaceC0652a;
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
            this.afZ.setText(str2);
            this.dHE.setText(str3);
            this.dIC.setText(str4);
            this.dIC.setTag(str4);
            this.kcb.setText(str5);
            this.kcb.setTag(strArr);
            this.dIC.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                IG(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                IG(str);
            }
            if (this.jeD != null) {
                this.jeD.setTag(strArr);
            }
            this.kbU.setTag(strArr);
            this.kbV.setTag(strArr);
        }
    }

    private void IG(String str) {
        if (kbX != null && !kbX.equals(str)) {
            kbW = null;
        }
        if (kbW != null) {
            this.kca.setImageBitmap(kbW.getRawBitmap());
            kbX = str;
            return;
        }
        this.kca.a(str, 12, this.kbY, this.kbY, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.dIC, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dHE, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.afZ, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.mLayout, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.kbT, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.kcb.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.kcb, R.color.cp_link_tip_c, 1);
    }
}
