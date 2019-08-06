package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes6.dex */
public class a extends v.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a isu;
    private static String isv;
    public TextView XL;
    public TextView cbg;
    public TextView ccd;
    public HeadImageView fOy;
    private final LinearLayout hzp;
    public ReplyLinearLayout isp;
    public TextView isq;
    protected final LinearLayout isr;
    protected final ColumnLayout iss;
    protected final ColumnLayout ist;
    private int isw;
    public LinearLayout isx;
    public TextView isy;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.isp = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.isp.setIsHost(this.mIsHost);
        this.isq = (TextView) view.findViewById(R.id.original_post_title);
        this.isx = (LinearLayout) view.findViewById(R.id.top_line);
        this.fOy = (HeadImageView) view.findViewById(R.id.portrait);
        this.XL = (TextView) view.findViewById(R.id.username);
        this.cbg = (TextView) view.findViewById(R.id.reply_time);
        this.ccd = (TextView) view.findViewById(R.id.forum_name);
        this.isy = (TextView) view.findViewById(R.id.reply_count);
        this.hzp = (LinearLayout) view.findViewById(R.id.item_content);
        this.iss = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ist = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.isr = (LinearLayout) view.findViewById(R.id.person_child);
        this.isw = l.dip2px(view.getContext(), 42.0f);
        if (this.hzp != null) {
            this.hzp.setOnClickListener(this);
        }
        this.fOy.setOnClickListener(this);
        this.XL.setOnClickListener(this);
        this.ccd.setOnClickListener(this);
        this.isy.setOnClickListener(this);
        this.iss.setOnClickListener(this);
        this.ist.setOnClickListener(this);
        this.isq.setOnClickListener(this);
    }

    public void iV(int i) {
        am.k(this.isq, R.color.cp_bg_line_e);
        am.l(getView(), R.color.cp_bg_line_c);
        am.k(this.isr, R.drawable.daily_recommend_item_selector);
        am.f(this.XL, R.color.cp_cont_d, 1);
        am.f(this.cbg, R.color.cp_cont_d, 1);
        am.f(this.ccd, R.color.cp_cont_d, 1);
        am.f(this.isy, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new an("c12043").P("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.ccd) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.isq && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00f2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String aD;
        String str7;
        String valueOf;
        String str8 = null;
        String str9 = 4;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            aD = aq.aD(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            aD = aq.aD(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = aD;
                        str2 = str7;
                        str9 = valueOf;
                        str8 = 1;
                        str5 = str9;
                    } catch (Exception e) {
                        str9 = str8;
                        str4 = str3;
                        str3 = str2;
                        str2 = str9;
                        str5 = str8;
                        str8 = null;
                        if (str8 != null) {
                        }
                    }
                } catch (Exception e2) {
                    str9 = str8;
                    str2 = str8;
                    str4 = str3;
                    str3 = str2;
                    str2 = str9;
                    str5 = str8;
                    str8 = null;
                    if (str8 != null) {
                    }
                }
            } catch (Exception e3) {
                str9 = 0;
                str2 = null;
                str3 = null;
                str4 = str3;
                str3 = str2;
                str2 = str9;
                str5 = str8;
                str8 = null;
                if (str8 != null) {
                }
            }
        } catch (Exception e4) {
            str4 = str3;
            str3 = str2;
            str2 = str9;
            str5 = str8;
            str8 = null;
            if (str8 != null) {
            }
        }
        if (str8 != null) {
            this.XL.setText(str4);
            this.cbg.setText(str3);
            this.ccd.setText(str2);
            this.ccd.setTag(str2);
            this.isy.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str5));
            this.ccd.setOnClickListener(this);
            CS(str);
            if (this.hzp != null) {
                this.hzp.setTag(strArr);
            }
            this.iss.setTag(strArr);
            this.ist.setTag(strArr);
        }
    }

    private void CS(String str) {
        if (isv != null && !isv.equals(str)) {
            isu = null;
        }
        if (isu != null) {
            this.fOy.setImageBitmap(isu.nK());
            isv = str;
            return;
        }
        this.fOy.startLoad(str, 12, this.isw, this.isw, false);
    }
}
