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
    private static com.baidu.adp.widget.ImageView.a iut;
    private static String iuu;
    public TextView XK;
    public TextView cbZ;
    public TextView ccX;
    public HeadImageView fQo;
    private final LinearLayout hBl;
    public ReplyLinearLayout iuo;
    public TextView iup;
    protected final LinearLayout iuq;
    protected final ColumnLayout iur;
    protected final ColumnLayout ius;
    private int iuv;
    public LinearLayout iuw;
    public TextView iux;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.iuo = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.iuo.setIsHost(this.mIsHost);
        this.iup = (TextView) view.findViewById(R.id.original_post_title);
        this.iuw = (LinearLayout) view.findViewById(R.id.top_line);
        this.fQo = (HeadImageView) view.findViewById(R.id.portrait);
        this.XK = (TextView) view.findViewById(R.id.username);
        this.cbZ = (TextView) view.findViewById(R.id.reply_time);
        this.ccX = (TextView) view.findViewById(R.id.forum_name);
        this.iux = (TextView) view.findViewById(R.id.reply_count);
        this.hBl = (LinearLayout) view.findViewById(R.id.item_content);
        this.iur = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ius = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.iuq = (LinearLayout) view.findViewById(R.id.person_child);
        this.iuv = l.dip2px(view.getContext(), 42.0f);
        if (this.hBl != null) {
            this.hBl.setOnClickListener(this);
        }
        this.fQo.setOnClickListener(this);
        this.XK.setOnClickListener(this);
        this.ccX.setOnClickListener(this);
        this.iux.setOnClickListener(this);
        this.iur.setOnClickListener(this);
        this.ius.setOnClickListener(this);
        this.iup.setOnClickListener(this);
    }

    public void iY(int i) {
        am.k(this.iup, R.color.cp_bg_line_e);
        am.l(getView(), R.color.cp_bg_line_c);
        am.k(this.iuq, R.drawable.daily_recommend_item_selector);
        am.f(this.XK, R.color.cp_cont_d, 1);
        am.f(this.cbZ, R.color.cp_cont_d, 1);
        am.f(this.ccX, R.color.cp_cont_d, 1);
        am.f(this.iux, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new an("c12043").P("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.ccX) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.iup && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
            this.XK.setText(str4);
            this.cbZ.setText(str3);
            this.ccX.setText(str2);
            this.ccX.setTag(str2);
            this.iux.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str5));
            this.ccX.setOnClickListener(this);
            Dr(str);
            if (this.hBl != null) {
                this.hBl.setTag(strArr);
            }
            this.iur.setTag(strArr);
            this.ius.setTag(strArr);
        }
    }

    private void Dr(String str) {
        if (iuu != null && !iuu.equals(str)) {
            iut = null;
        }
        if (iut != null) {
            this.fQo.setImageBitmap(iut.nK());
            iuu = str;
            return;
        }
        this.fQo.startLoad(str, 12, this.iuv, this.iuv, false);
    }
}
