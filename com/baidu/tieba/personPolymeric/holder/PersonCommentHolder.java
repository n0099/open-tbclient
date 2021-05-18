package com.baidu.tieba.personPolymeric.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
import d.a.c.e.p.l;
import d.a.c.j.d.a;
/* loaded from: classes5.dex */
public class PersonCommentHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static a t;
    public static String u;

    /* renamed from: e  reason: collision with root package name */
    public ReplyLinearLayout f19928e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19929f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f19930g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f19931h;

    /* renamed from: i  reason: collision with root package name */
    public final ColumnLayout f19932i;
    public final ColumnLayout j;
    public int k;
    public LinearLayout l;
    public HeadImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TbPageContext<?> r;
    public boolean s;

    public PersonCommentHolder(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.r = tbPageContext;
        this.s = z;
        ReplyLinearLayout replyLinearLayout = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.f19928e = replyLinearLayout;
        replyLinearLayout.setIsHost(this.s);
        this.f19929f = (TextView) view.findViewById(R.id.original_post_title);
        this.l = (LinearLayout) view.findViewById(R.id.top_line);
        this.m = (HeadImageView) view.findViewById(R.id.portrait);
        this.n = (TextView) view.findViewById(R.id.username);
        this.o = (TextView) view.findViewById(R.id.reply_time);
        this.p = (TextView) view.findViewById(R.id.forum_name);
        this.q = (TextView) view.findViewById(R.id.reply_count);
        this.f19931h = (LinearLayout) view.findViewById(R.id.item_content);
        this.f19932i = (ColumnLayout) view.findViewById(R.id.item_header);
        this.j = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.f19930g = (LinearLayout) view.findViewById(R.id.person_child);
        this.k = l.e(view.getContext(), 42.0f);
        LinearLayout linearLayout = this.f19931h;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.f19932i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.f19929f.setOnClickListener(this);
    }

    public void b(int i2) {
        SkinManager.setBackgroundResource(this.f19929f, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(a(), R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f19930g, R.drawable.daily_recommend_item_selector);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0109, 1);
    }

    public final void c(String str) {
        String str2 = u;
        if (str2 != null && !str2.equals(str)) {
            t = null;
        }
        a aVar = t;
        if (aVar != null) {
            this.m.setImageBitmap(aVar.p());
            u = str;
            return;
        }
        HeadImageView headImageView = this.m;
        int i2 = this.k;
        headImageView.R(str, 12, i2, i2, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0009 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Type inference failed for: r11v9, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        boolean z2;
        ?? r12;
        CharSequence charSequence5;
        CharSequence charSequence6;
        String[] strArr = new String[4];
        ?? r2 = 1000;
        r2 = 1000;
        CharSequence charSequence7 = null;
        try {
            try {
                try {
                    try {
                        if (z) {
                            boolean z3 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String formatTime = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            charSequence3 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            r2 = formatTime;
                            z = z3;
                        } else {
                            boolean z4 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            String formatTime2 = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            charSequence3 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            r2 = formatTime2;
                            z = z4;
                        }
                        z2 = true;
                        charSequence6 = r2;
                        charSequence4 = z;
                    } catch (Exception unused) {
                        charSequence = charSequence7;
                        CharSequence charSequence8 = charSequence;
                        charSequence3 = charSequence8;
                        charSequence5 = charSequence8;
                        r12 = z;
                        charSequence7 = r12;
                        charSequence2 = charSequence5;
                        charSequence4 = charSequence7;
                        charSequence7 = charSequence;
                        z2 = false;
                        charSequence6 = charSequence2;
                        if (z2) {
                        }
                    }
                } catch (Exception unused2) {
                    charSequence = charSequence7;
                    charSequence3 = charSequence;
                    charSequence5 = r2;
                    r12 = z;
                    charSequence7 = r12;
                    charSequence2 = charSequence5;
                    charSequence4 = charSequence7;
                    charSequence7 = charSequence;
                    z2 = false;
                    charSequence6 = charSequence2;
                    if (z2) {
                    }
                }
            } catch (Exception unused3) {
                charSequence = null;
                charSequence2 = null;
                charSequence3 = null;
                charSequence4 = charSequence7;
                charSequence7 = charSequence;
                z2 = false;
                charSequence6 = charSequence2;
                if (z2) {
                }
            }
        } catch (Exception unused4) {
            charSequence = charSequence7;
            charSequence5 = r2;
            r12 = z;
            charSequence7 = r12;
            charSequence2 = charSequence5;
            charSequence4 = charSequence7;
            charSequence7 = charSequence;
            z2 = false;
            charSequence6 = charSequence2;
            if (z2) {
            }
        }
        if (z2) {
            this.n.setText(charSequence4);
            this.o.setText(charSequence6);
            this.p.setText(charSequence3);
            this.p.setTag(charSequence3);
            this.q.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), charSequence7));
            this.p.setOnClickListener(this);
            c(str);
            LinearLayout linearLayout = this.f19931h;
            if (linearLayout != null) {
                linearLayout.setTag(strArr);
            }
            this.f19932i.setTag(strArr);
            this.j.setTag(strArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new StatisticItem("c12043").param("obj_type", this.s ? 1 : 2));
        if (view == this.p) {
            if (this.r != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.r.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view != this.f19929f || (strArr = (String[]) view.getTag()) == null || strArr.length < 4 || strArr[3] == null) {
        } else {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.r.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            }
        }
    }
}
