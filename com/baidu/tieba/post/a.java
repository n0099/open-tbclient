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
    private static com.baidu.adp.widget.ImageView.a jpQ;
    private static String jpR;
    public TextView Nl;
    public TextView dhe;
    public TextView dib;
    public HeadImageView gIs;
    private final LinearLayout isG;
    protected final LinearLayout jpN;
    protected final ColumnLayout jpO;
    protected final ColumnLayout jpP;
    private int jpS;
    public LinearLayout jpT;
    public TextView jpU;
    private InterfaceC0591a jzJ;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0591a {
        void cM(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jpT = (LinearLayout) view.findViewById(R.id.top_line);
        this.gIs = (HeadImageView) view.findViewById(R.id.portrait);
        this.Nl = (TextView) view.findViewById(R.id.username);
        this.dhe = (TextView) view.findViewById(R.id.reply_time);
        this.dib = (TextView) view.findViewById(R.id.forum_name);
        this.jpU = (TextView) view.findViewById(R.id.reply_count);
        this.isG = (LinearLayout) view.findViewById(R.id.item_content);
        this.jpO = (ColumnLayout) view.findViewById(R.id.item_header);
        this.jpP = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.jpN = (LinearLayout) view.findViewById(R.id.person_child);
        this.jpS = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.isG != null) {
            this.isG.setOnClickListener(this);
        }
        this.gIs.setOnClickListener(this);
        this.Nl.setOnClickListener(this);
        this.dib.setOnClickListener(this);
        this.jpU.setOnClickListener(this);
        this.jpO.setOnClickListener(this);
        this.jpP.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.jzJ != null) {
            this.jzJ.cM(view);
        }
    }

    public void a(InterfaceC0591a interfaceC0591a) {
        this.jzJ = interfaceC0591a;
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
            this.Nl.setText(str2);
            this.dhe.setText(str3);
            this.dib.setText(str4);
            this.dib.setTag(str4);
            this.jpU.setText(str5);
            this.jpU.setTag(strArr);
            this.dib.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                GV(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                GV(str);
            }
            if (this.isG != null) {
                this.isG.setTag(strArr);
            }
            this.jpO.setTag(strArr);
            this.jpP.setTag(strArr);
        }
    }

    private void GV(String str) {
        if (jpR != null && !jpR.equals(str)) {
            jpQ = null;
        }
        if (jpQ != null) {
            this.gIs.setImageBitmap(jpQ.getRawBitmap());
            jpR = str;
            return;
        }
        this.gIs.a(str, 12, this.jpS, this.jpS, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.dib, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dhe, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.Nl, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.mLayout, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.jpN, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.jpU.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.jpU, R.color.cp_link_tip_c, 1);
    }
}
