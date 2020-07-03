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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a kOR;
    private static String kOS;
    public TextView ahA;
    public TextView edq;
    public TextView een;
    private final LinearLayout jMd;
    private final LinearLayout jeE;
    protected final LinearLayout kOO;
    protected final ColumnLayout kOP;
    protected final ColumnLayout kOQ;
    private int kOT;
    public LinearLayout kOU;
    public HeadImageView kOV;
    public TextView kOW;
    private InterfaceC0722a kYE;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0722a {
        void cW(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.kOU = (LinearLayout) view.findViewById(R.id.top_line);
        this.kOV = (HeadImageView) view.findViewById(R.id.portrait);
        this.ahA = (TextView) view.findViewById(R.id.username);
        this.edq = (TextView) view.findViewById(R.id.reply_time);
        this.een = (TextView) view.findViewById(R.id.forum_name);
        this.kOW = (TextView) view.findViewById(R.id.reply_count);
        this.jMd = (LinearLayout) view.findViewById(R.id.item_content);
        this.kOP = (ColumnLayout) view.findViewById(R.id.item_header);
        this.kOQ = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.jeE = (LinearLayout) view.findViewById(R.id.person_thread);
        this.kOO = (LinearLayout) view.findViewById(R.id.person_child);
        this.kOT = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.jMd != null) {
            this.jMd.setOnClickListener(this);
        }
        this.kOV.setOnClickListener(this);
        this.ahA.setOnClickListener(this);
        this.een.setOnClickListener(this);
        this.kOW.setOnClickListener(this);
        this.kOP.setOnClickListener(this);
        this.kOQ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.kYE != null) {
            this.kYE.cW(view);
        }
    }

    public void a(InterfaceC0722a interfaceC0722a) {
        this.kYE = interfaceC0722a;
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
                str3 = ar.getFormatTime(postInfoList.create_time * 1000);
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
                str3 = ar.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.ahA.setText(str2);
            this.edq.setText(str3);
            this.een.setText(str4);
            this.een.setTag(str4);
            this.kOW.setText(str5);
            this.kOW.setTag(strArr);
            this.een.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                KU(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                KU(str);
            }
            if (this.jMd != null) {
                this.jMd.setTag(strArr);
            }
            this.kOP.setTag(strArr);
            this.kOQ.setTag(strArr);
        }
    }

    private void KU(String str) {
        if (kOS != null && !kOS.equals(str)) {
            kOR = null;
        }
        if (kOR != null) {
            this.kOV.setImageBitmap(kOR.getRawBitmap());
            kOS = str;
            return;
        }
        this.kOV.a(str, 12, this.kOT, this.kOT, false);
    }

    public void changeSkin(int i) {
        an.setViewTextColor(this.een, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.edq, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.ahA, R.color.cp_cont_f, 1);
        an.setBackgroundResource(this.jeE, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.kOO, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.kOW.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        an.setViewTextColor(this.kOW, R.color.cp_link_tip_c, 1);
    }
}
