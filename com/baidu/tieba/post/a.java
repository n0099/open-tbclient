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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a kXN;
    private static String kXO;
    public TextView ahr;
    public TextView ejA;
    public TextView ekx;
    private final LinearLayout jUB;
    private final LinearLayout jna;
    protected final LinearLayout kXK;
    protected final ColumnLayout kXL;
    protected final ColumnLayout kXM;
    private int kXP;
    public LinearLayout kXQ;
    public HeadImageView kXR;
    public TextView kXS;
    private InterfaceC0732a lfV;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0732a {
        void dc(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.kXQ = (LinearLayout) view.findViewById(R.id.top_line);
        this.kXR = (HeadImageView) view.findViewById(R.id.portrait);
        this.ahr = (TextView) view.findViewById(R.id.username);
        this.ejA = (TextView) view.findViewById(R.id.reply_time);
        this.ekx = (TextView) view.findViewById(R.id.forum_name);
        this.kXS = (TextView) view.findViewById(R.id.reply_count);
        this.jUB = (LinearLayout) view.findViewById(R.id.item_content);
        this.kXL = (ColumnLayout) view.findViewById(R.id.item_header);
        this.kXM = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.jna = (LinearLayout) view.findViewById(R.id.person_thread);
        this.kXK = (LinearLayout) view.findViewById(R.id.person_child);
        this.kXP = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.jUB != null) {
            this.jUB.setOnClickListener(this);
        }
        this.kXR.setOnClickListener(this);
        this.ahr.setOnClickListener(this);
        this.ekx.setOnClickListener(this);
        this.kXS.setOnClickListener(this);
        this.kXL.setOnClickListener(this);
        this.kXM.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.lfV != null) {
            this.lfV.dc(view);
        }
    }

    public void a(InterfaceC0732a interfaceC0732a) {
        this.lfV = interfaceC0732a;
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
                str3 = as.getFormatTime(postInfoList.create_time * 1000);
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
                str3 = as.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.ahr.setText(str2);
            this.ejA.setText(str3);
            this.ekx.setText(str4);
            this.ekx.setTag(str4);
            this.kXS.setText(str5);
            this.kXS.setTag(strArr);
            this.ekx.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                LI(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                LI(str);
            }
            if (this.jUB != null) {
                this.jUB.setTag(strArr);
            }
            this.kXL.setTag(strArr);
            this.kXM.setTag(strArr);
        }
    }

    private void LI(String str) {
        if (kXO != null && !kXO.equals(str)) {
            kXN = null;
        }
        if (kXN != null) {
            this.kXR.setImageBitmap(kXN.getRawBitmap());
            kXO = str;
            return;
        }
        this.kXR.a(str, 12, this.kXP, this.kXP, false);
    }

    public void changeSkin(int i) {
        ao.setViewTextColor(this.ekx, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.ejA, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.ahr, R.color.cp_cont_f, 1);
        ao.setBackgroundResource(this.jna, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.kXK, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.kXS.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setViewTextColor(this.kXS, R.color.cp_link_tip_c, 1);
    }
}
