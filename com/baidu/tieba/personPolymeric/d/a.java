package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes3.dex */
public class a extends q.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a grK;
    private static String grL;
    public TextView aFx;
    public TextView aGP;
    public TextView aGk;
    public HeadImageView dUm;
    private final LinearLayout fAz;
    public ReplyLinearLayout grF;
    public TextView grG;
    protected final LinearLayout grH;
    protected final ColumnLayout grI;
    protected final ColumnLayout grJ;
    private int grM;
    public LinearLayout grN;
    public TextView grO;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.grF = (ReplyLinearLayout) view.findViewById(e.g.content_container);
        this.grF.setIsHost(this.mIsHost);
        this.grG = (TextView) view.findViewById(e.g.original_post_title);
        this.grN = (LinearLayout) view.findViewById(e.g.top_line);
        this.dUm = (HeadImageView) view.findViewById(e.g.portrait);
        this.aGP = (TextView) view.findViewById(e.g.username);
        this.aFx = (TextView) view.findViewById(e.g.reply_time);
        this.aGk = (TextView) view.findViewById(e.g.forum_name);
        this.grO = (TextView) view.findViewById(e.g.reply_count);
        this.fAz = (LinearLayout) view.findViewById(e.g.item_content);
        this.grI = (ColumnLayout) view.findViewById(e.g.item_header);
        this.grJ = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.grH = (LinearLayout) view.findViewById(e.g.person_child);
        this.grM = l.dip2px(view.getContext(), 42.0f);
        if (this.fAz != null) {
            this.fAz.setOnClickListener(this);
        }
        this.dUm.setOnClickListener(this);
        this.aGP.setOnClickListener(this);
        this.aGk.setOnClickListener(this);
        this.grO.setOnClickListener(this);
        this.grI.setOnClickListener(this);
        this.grJ.setOnClickListener(this);
        this.grG.setOnClickListener(this);
    }

    public void ek(int i) {
        al.i(this.grG, e.d.cp_bg_line_e);
        al.j(getView(), e.d.cp_bg_line_c);
        al.i(this.grH, e.f.daily_recommend_item_selector);
        al.c(this.aGP, e.d.cp_cont_d, 1);
        al.c(this.aFx, e.d.cp_cont_d, 1);
        al.c(this.aGk, e.d.cp_cont_d, 1);
        al.c(this.grO, e.d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new am("c12043").x("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.aGk) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.grG && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
        String E;
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
                            E = ao.E(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            E = ao.E(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = E;
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
            this.aGP.setText(str4);
            this.aFx.setText(str3);
            this.aGk.setText(str2);
            this.aGk.setTag(str2);
            this.grO.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(e.j.comment_num_tip), str5));
            this.aGk.setOnClickListener(this);
            tm(str);
            if (this.fAz != null) {
                this.fAz.setTag(strArr);
            }
            this.grI.setTag(strArr);
            this.grJ.setTag(strArr);
        }
    }

    private void tm(String str) {
        if (grL != null && !grL.equals(str)) {
            grK = null;
        }
        if (grK != null) {
            this.dUm.setImageBitmap(grK.oq());
            grL = str;
            return;
        }
        this.dUm.startLoad(str, 12, this.grM, this.grM, false);
    }
}
