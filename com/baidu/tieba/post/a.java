package com.baidu.tieba.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
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
    private static com.baidu.adp.widget.ImageView.a iut;
    private static String iuu;
    public TextView XK;
    public TextView cbZ;
    public TextView ccX;
    public HeadImageView fQo;
    private final LinearLayout hBl;
    private InterfaceC0405a iDy;
    protected final LinearLayout iuq;
    protected final ColumnLayout iur;
    protected final ColumnLayout ius;
    private int iuv;
    public LinearLayout iuw;
    public TextView iux;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0405a {
        void cO(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.iuw = (LinearLayout) view.findViewById(R.id.top_line);
        this.fQo = (HeadImageView) view.findViewById(R.id.portrait);
        this.XK = (TextView) view.findViewById(R.id.username);
        this.cbZ = (TextView) view.findViewById(R.id.reply_time);
        this.ccX = (TextView) view.findViewById(R.id.forum_name);
        this.iux = (TextView) view.findViewById(R.id.reply_count);
        this.hBl = (LinearLayout) view.findViewById(R.id.item_content);
        this.iur = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ius = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.iuq = (LinearLayout) view.findViewById(R.id.person_child);
        this.iuv = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.hBl != null) {
            this.hBl.setOnClickListener(this);
        }
        this.fQo.setOnClickListener(this);
        this.XK.setOnClickListener(this);
        this.ccX.setOnClickListener(this);
        this.iux.setOnClickListener(this);
        this.iur.setOnClickListener(this);
        this.ius.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.iDy != null) {
            this.iDy.cO(view);
        }
    }

    public void a(InterfaceC0405a interfaceC0405a) {
        this.iDy = interfaceC0405a;
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
                str3 = aq.aD(postInfoList.create_time * 1000);
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
                str3 = aq.aD(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.XK.setText(str2);
            this.cbZ.setText(str3);
            this.ccX.setText(str4);
            this.ccX.setTag(str4);
            this.iux.setText(str5);
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

    public void iY(int i) {
        am.f(this.ccX, R.color.cp_cont_d, 1);
        am.f(this.cbZ, R.color.cp_cont_d, 1);
        am.f(this.XK, R.color.cp_cont_f, 1);
        am.k(this.mLayout, R.color.cp_bg_line_c);
        am.k(this.iuq, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.iux.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.f(this.iux, R.color.cp_link_tip_c, 1);
    }
}
