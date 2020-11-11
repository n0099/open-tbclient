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
    private static com.baidu.adp.widget.ImageView.a meN;
    private static String meO;
    public TextView aju;
    public TextView eVY;
    public TextView eWV;
    private final LinearLayout ksb;
    private final LinearLayout lak;
    private TbPageContext<?> mPageContext;
    protected final LinearLayout meK;
    protected final ColumnLayout meL;
    protected final ColumnLayout meM;
    private int meP;
    public LinearLayout meQ;
    public HeadImageView meR;
    public TextView meS;
    private InterfaceC0828a mnd;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0828a {
        void dB(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.meQ = (LinearLayout) view.findViewById(R.id.top_line);
        this.meR = (HeadImageView) view.findViewById(R.id.portrait);
        this.aju = (TextView) view.findViewById(R.id.username);
        this.eVY = (TextView) view.findViewById(R.id.reply_time);
        this.eWV = (TextView) view.findViewById(R.id.forum_name);
        this.meS = (TextView) view.findViewById(R.id.reply_count);
        this.lak = (LinearLayout) view.findViewById(R.id.item_content);
        this.meL = (ColumnLayout) view.findViewById(R.id.item_header);
        this.meM = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.ksb = (LinearLayout) view.findViewById(R.id.person_thread);
        this.meK = (LinearLayout) view.findViewById(R.id.person_child);
        this.meP = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.lak != null) {
            this.lak.setOnClickListener(this);
        }
        this.meR.setOnClickListener(this);
        this.aju.setOnClickListener(this);
        this.eWV.setOnClickListener(this);
        this.meS.setOnClickListener(this);
        this.meL.setOnClickListener(this);
        this.meM.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.mnd != null) {
            this.mnd.dB(view);
        }
    }

    public void a(InterfaceC0828a interfaceC0828a) {
        this.mnd = interfaceC0828a;
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
            this.eVY.setText(str3);
            this.eWV.setText(str4);
            this.eWV.setTag(str4);
            this.meS.setText(str5);
            this.meS.setTag(strArr);
            this.eWV.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                QH(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                QH(str);
            }
            if (this.lak != null) {
                this.lak.setTag(strArr);
            }
            this.meL.setTag(strArr);
            this.meM.setTag(strArr);
        }
    }

    private void QH(String str) {
        if (meO != null && !meO.equals(str)) {
            meN = null;
        }
        if (meN != null) {
            this.meR.setImageBitmap(meN.getRawBitmap());
            meO = str;
            return;
        }
        this.meR.a(str, 12, this.meP, this.meP, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.eWV, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.eVY, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.aju, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.ksb, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.meK, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.meS.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.meS, R.color.cp_link_tip_c, 1);
    }
}
