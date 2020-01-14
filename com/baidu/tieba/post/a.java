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
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a joU;
    private static String joV;
    public TextView MK;
    public TextView dcZ;
    public TextView ddX;
    public HeadImageView gGt;
    private final LinearLayout iqL;
    protected final LinearLayout joR;
    protected final ColumnLayout joS;
    protected final ColumnLayout joT;
    private int joW;
    public LinearLayout joX;
    public TextView joY;
    private InterfaceC0583a jyT;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0583a {
        void cL(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.joX = (LinearLayout) view.findViewById(R.id.top_line);
        this.gGt = (HeadImageView) view.findViewById(R.id.portrait);
        this.MK = (TextView) view.findViewById(R.id.username);
        this.dcZ = (TextView) view.findViewById(R.id.reply_time);
        this.ddX = (TextView) view.findViewById(R.id.forum_name);
        this.joY = (TextView) view.findViewById(R.id.reply_count);
        this.iqL = (LinearLayout) view.findViewById(R.id.item_content);
        this.joS = (ColumnLayout) view.findViewById(R.id.item_header);
        this.joT = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.joR = (LinearLayout) view.findViewById(R.id.person_child);
        this.joW = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.iqL != null) {
            this.iqL.setOnClickListener(this);
        }
        this.gGt.setOnClickListener(this);
        this.MK.setOnClickListener(this);
        this.ddX.setOnClickListener(this);
        this.joY.setOnClickListener(this);
        this.joS.setOnClickListener(this);
        this.joT.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.jyT != null) {
            this.jyT.cL(view);
        }
    }

    public void a(InterfaceC0583a interfaceC0583a) {
        this.jyT = interfaceC0583a;
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
            this.MK.setText(str2);
            this.dcZ.setText(str3);
            this.ddX.setText(str4);
            this.ddX.setTag(str4);
            this.joY.setText(str5);
            this.ddX.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                GH(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                GH(str);
            }
            if (this.iqL != null) {
                this.iqL.setTag(strArr);
            }
            this.joS.setTag(strArr);
            this.joT.setTag(strArr);
        }
    }

    private void GH(String str) {
        if (joV != null && !joV.equals(str)) {
            joU = null;
        }
        if (joU != null) {
            this.gGt.setImageBitmap(joU.getRawBitmap());
            joV = str;
            return;
        }
        this.gGt.a(str, 12, this.joW, this.joW, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.ddX, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dcZ, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.MK, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.mLayout, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.joR, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.joY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.joY, R.color.cp_link_tip_c, 1);
    }
}
