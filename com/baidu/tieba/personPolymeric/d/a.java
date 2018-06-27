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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes3.dex */
public class a extends q.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a gbb;
    private static String gbc;
    public TextView axj;
    public TextView ayV;
    public TextView ayf;
    public TextView eXF;
    private final LinearLayout fjU;
    public ReplyLinearLayout gaW;
    public TextView gaX;
    protected final LinearLayout gaY;
    protected final ColumnLayout gaZ;
    protected final ColumnLayout gba;
    private int gbd;
    public LinearLayout gbe;
    public HeadImageView gbf;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gaW = (ReplyLinearLayout) view.findViewById(d.g.content_container);
        this.gaW.setIsHost(this.mIsHost);
        this.gaX = (TextView) view.findViewById(d.g.original_post_title);
        this.gbe = (LinearLayout) view.findViewById(d.g.top_line);
        this.gbf = (HeadImageView) view.findViewById(d.g.portrait);
        this.ayf = (TextView) view.findViewById(d.g.username);
        this.axj = (TextView) view.findViewById(d.g.reply_time);
        this.ayV = (TextView) view.findViewById(d.g.forum_name);
        this.eXF = (TextView) view.findViewById(d.g.reply_count);
        this.fjU = (LinearLayout) view.findViewById(d.g.item_content);
        this.gaZ = (ColumnLayout) view.findViewById(d.g.item_header);
        this.gba = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.gaY = (LinearLayout) view.findViewById(d.g.person_child);
        this.gbd = l.dip2px(view.getContext(), 42.0f);
        if (this.fjU != null) {
            this.fjU.setOnClickListener(this);
        }
        this.gbf.setOnClickListener(this);
        this.ayf.setOnClickListener(this);
        this.ayV.setOnClickListener(this);
        this.eXF.setOnClickListener(this);
        this.gaZ.setOnClickListener(this);
        this.gba.setOnClickListener(this);
        this.gaX.setOnClickListener(this);
    }

    public void dz(int i) {
        am.i(this.gaX, d.C0142d.cp_bg_line_e);
        am.j(getView(), d.C0142d.cp_bg_line_c);
        am.i(this.gaY, d.f.daily_recommend_item_selector);
        am.c(this.ayf, d.C0142d.cp_cont_d, 1);
        am.c(this.axj, d.C0142d.cp_cont_d, 1);
        am.c(this.ayV, d.C0142d.cp_cont_d, 1);
        am.c(this.eXF, d.C0142d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new an("c12043").r("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.ayV) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.gaX && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
        String w;
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
                            w = ap.w(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            w = ap.w(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = w;
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
            this.ayf.setText(str4);
            this.axj.setText(str3);
            this.ayV.setText(str2);
            this.ayV.setTag(str2);
            this.eXF.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.k.comment_num_tip), str5));
            this.ayV.setOnClickListener(this);
            sd(str);
            if (this.fjU != null) {
                this.fjU.setTag(strArr);
            }
            this.gaZ.setTag(strArr);
            this.gba.setTag(strArr);
        }
    }

    private void sd(String str) {
        if (gbc != null && !gbc.equals(str)) {
            gbb = null;
        }
        if (gbb != null) {
            this.gbf.setImageBitmap(gbb.mZ());
            gbc = str;
            return;
        }
        this.gbf.startLoad(str, 12, this.gbd, this.gbd, false);
    }
}
