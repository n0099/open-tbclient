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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes6.dex */
public class a extends v.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a hSi;
    private static String hSj;
    public TextView Zz;
    public TextView bSe;
    public TextView bTb;
    public HeadImageView fso;
    public ReplyLinearLayout hSd;
    public TextView hSe;
    protected final LinearLayout hSf;
    protected final ColumnLayout hSg;
    protected final ColumnLayout hSh;
    private int hSk;
    public LinearLayout hSl;
    public TextView hSm;
    private final LinearLayout haQ;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.hSd = (ReplyLinearLayout) view.findViewById(d.g.content_container);
        this.hSd.setIsHost(this.mIsHost);
        this.hSe = (TextView) view.findViewById(d.g.original_post_title);
        this.hSl = (LinearLayout) view.findViewById(d.g.top_line);
        this.fso = (HeadImageView) view.findViewById(d.g.portrait);
        this.Zz = (TextView) view.findViewById(d.g.username);
        this.bSe = (TextView) view.findViewById(d.g.reply_time);
        this.bTb = (TextView) view.findViewById(d.g.forum_name);
        this.hSm = (TextView) view.findViewById(d.g.reply_count);
        this.haQ = (LinearLayout) view.findViewById(d.g.item_content);
        this.hSg = (ColumnLayout) view.findViewById(d.g.item_header);
        this.hSh = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.hSf = (LinearLayout) view.findViewById(d.g.person_child);
        this.hSk = l.dip2px(view.getContext(), 42.0f);
        if (this.haQ != null) {
            this.haQ.setOnClickListener(this);
        }
        this.fso.setOnClickListener(this);
        this.Zz.setOnClickListener(this);
        this.bTb.setOnClickListener(this);
        this.hSm.setOnClickListener(this);
        this.hSg.setOnClickListener(this);
        this.hSh.setOnClickListener(this);
        this.hSe.setOnClickListener(this);
    }

    public void ib(int i) {
        al.k(this.hSe, d.C0277d.cp_bg_line_e);
        al.l(getView(), d.C0277d.cp_bg_line_c);
        al.k(this.hSf, d.f.daily_recommend_item_selector);
        al.d(this.Zz, d.C0277d.cp_cont_d, 1);
        al.d(this.bSe, d.C0277d.cp_cont_d, 1);
        al.d(this.bTb, d.C0277d.cp_cont_d, 1);
        al.d(this.hSm, d.C0277d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new am("c12043").T("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.bTb) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.hSe && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00f1 */
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
        String ao;
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
                            ao = ap.ao(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            ao = ap.ao(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = ao;
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
            this.Zz.setText(str4);
            this.bSe.setText(str3);
            this.bTb.setText(str2);
            this.bTb.setTag(str2);
            this.hSm.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.j.comment_num_tip), str5));
            this.bTb.setOnClickListener(this);
            AK(str);
            if (this.haQ != null) {
                this.haQ.setTag(strArr);
            }
            this.hSg.setTag(strArr);
            this.hSh.setTag(strArr);
        }
    }

    private void AK(String str) {
        if (hSj != null && !hSj.equals(str)) {
            hSi = null;
        }
        if (hSi != null) {
            this.fso.setImageBitmap(hSi.oy());
            hSj = str;
            return;
        }
        this.fso.startLoad(str, 12, this.hSk, this.hSk, false);
    }
}
