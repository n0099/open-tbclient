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
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a isU;
    private static String isV;
    public TextView HE;
    public TextView cqn;
    public TextView crl;
    public HeadImageView fPI;
    private final LinearLayout hzU;
    private InterfaceC0499a iBU;
    protected final LinearLayout isR;
    protected final ColumnLayout isS;
    protected final ColumnLayout isT;
    private int isW;
    public LinearLayout isX;
    public TextView isY;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0499a {
        void cK(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.isX = (LinearLayout) view.findViewById(R.id.top_line);
        this.fPI = (HeadImageView) view.findViewById(R.id.portrait);
        this.HE = (TextView) view.findViewById(R.id.username);
        this.cqn = (TextView) view.findViewById(R.id.reply_time);
        this.crl = (TextView) view.findViewById(R.id.forum_name);
        this.isY = (TextView) view.findViewById(R.id.reply_count);
        this.hzU = (LinearLayout) view.findViewById(R.id.item_content);
        this.isS = (ColumnLayout) view.findViewById(R.id.item_header);
        this.isT = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.isR = (LinearLayout) view.findViewById(R.id.person_child);
        this.isW = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.hzU != null) {
            this.hzU.setOnClickListener(this);
        }
        this.fPI.setOnClickListener(this);
        this.HE.setOnClickListener(this);
        this.crl.setOnClickListener(this);
        this.isY.setOnClickListener(this);
        this.isS.setOnClickListener(this);
        this.isT.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.iBU != null) {
            this.iBU.cK(view);
        }
    }

    public void a(InterfaceC0499a interfaceC0499a) {
        this.iBU = interfaceC0499a;
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
            this.HE.setText(str2);
            this.cqn.setText(str3);
            this.crl.setText(str4);
            this.crl.setTag(str4);
            this.isY.setText(str5);
            this.crl.setOnClickListener(this);
            BK(str);
            if (this.hzU != null) {
                this.hzU.setTag(strArr);
            }
            this.isS.setTag(strArr);
            this.isT.setTag(strArr);
        }
    }

    private void BK(String str) {
        if (isV != null && !isV.equals(str)) {
            isU = null;
        }
        if (isU != null) {
            this.fPI.setImageBitmap(isU.getRawBitmap());
            isV = str;
            return;
        }
        this.fPI.a(str, 12, this.isW, this.isW, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.crl, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.cqn, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.HE, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.mLayout, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.isR, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.isY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.isY, R.color.cp_link_tip_c, 1);
    }
}
