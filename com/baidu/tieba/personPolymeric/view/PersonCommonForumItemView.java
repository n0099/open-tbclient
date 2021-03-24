package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import d.b.i0.h2.e.f;
/* loaded from: classes5.dex */
public class PersonCommonForumItemView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public BarImageView f20471e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20472f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20473g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20474h;
    public TextView i;
    public int j;
    public Context k;
    public f l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || PersonCommonForumItemView.this.l == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "6"));
            TiebaStatic.log(new StatisticItem("c11594"));
            String str = PersonCommonForumItemView.this.l.f55283f;
            if (k.isForumName(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.k).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
            }
        }
    }

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.j = 3;
        this.k = context;
        LayoutInflater.from(getContext()).inflate(R.layout.person_info_common_forum_item, (ViewGroup) this, true);
        c();
        d();
    }

    public final void c() {
        this.f20471e = (BarImageView) findViewById(R.id.forum_avatar);
        this.f20472f = (TextView) findViewById(R.id.forum_name);
        this.f20473g = (TextView) findViewById(R.id.forum_post_thread);
        this.f20474h = (TextView) findViewById(R.id.forum_thread_num);
        this.i = (TextView) findViewById(R.id.forum_thread_str);
    }

    public final void d() {
        this.m = new a();
    }

    public void e() {
        if (this.j != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setViewTextColor(this.f20472f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f20473g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f20474h, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
        }
        this.j = TbadkCoreApplication.getInst().getSkinType();
    }

    public void setData(f fVar) {
        this.l = fVar;
        this.f20471e.W(fVar.f55284g, 10, false);
        TextView textView = this.f20472f;
        textView.setText(StringHelper.cutForumNameWithSuffix(fVar.f55283f, 7, StringHelper.STRING_MORE) + this.k.getString(R.string.forum));
        this.f20474h.setText(StringHelper.numberUniformFormat((long) fVar.f55285h));
        this.f20473g.setText(String.format(this.k.getString(R.string.person_has_posted), StringHelper.getUserDescByGender(fVar.i)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.m);
        }
        e();
    }
}
