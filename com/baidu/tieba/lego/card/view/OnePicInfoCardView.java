package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.OnePicInfoCard;
import d.a.j0.d3.n0.d;
import d.a.j0.j1.i;
import d.a.j0.j1.o.f;
/* loaded from: classes4.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    public TbImageView A;
    public TextView B;
    public int C;
    public int D;
    public ViewGroup r;
    public TbImageView s;
    public LineCountNotifyTextView t;
    public TextView u;
    public TextView v;
    public LinearLayout w;
    public TbImageView x;
    public TextView y;
    public LinearLayout z;

    /* loaded from: classes4.dex */
    public class a implements LineCountNotifyTextView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCard f18703a;

        public a(OnePicInfoCard onePicInfoCard) {
            this.f18703a = onePicInfoCard;
        }

        @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
        public void a() {
            int lineCount = OnePicInfoCardView.this.t.getLineCount();
            if (OnePicInfoCardView.this.D != lineCount) {
                if (lineCount == 1) {
                    OnePicInfoCardView.this.u.setMaxLines(2);
                } else {
                    OnePicInfoCardView.this.u.setMaxLines(1);
                }
            }
            OnePicInfoCardView.this.D = lineCount;
            OnePicInfoCardView.this.u.setText(this.f18703a.getDesc());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OnePicInfoCard f18705e;

        public b(OnePicInfoCard onePicInfoCard) {
            this.f18705e = onePicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnePicInfoCardView.this.q(this.f18705e);
        }
    }

    public OnePicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.C = 0;
        this.D = -1;
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        if (this.v == null) {
            return;
        }
        if (onePicInfoCard != null && !d.a.j0.j1.o.k.b.a(onePicInfoCard.gettBgColor()) && !d.a.j0.j1.o.k.b.a(onePicInfoCard.gettBgColorN())) {
            this.v.setBackgroundColor(v() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
        } else {
            SkinManager.setBackgroundResource(this.v, R.drawable.label_bg_tie_n);
        }
    }

    public final void N(TextView textView, TbImageView tbImageView, d.a.j0.j1.o.j.b bVar) {
        String str = v() ? bVar.f55773b : bVar.f55772a;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.V(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(f.a(bVar.f55774c)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        try {
            textView.setText(StringHelper.numberUniformFormat(Long.parseLong(bVar.f55775d)));
        } catch (NumberFormatException unused) {
            textView.setText(bVar.f55775d);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: O */
    public void x(OnePicInfoCard onePicInfoCard, int i2) {
        LineCountNotifyTextView lineCountNotifyTextView;
        d.a.i0.s0.a.a(this.m, getRootView());
        SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
        setTagBg(onePicInfoCard);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.y, R.color.CAM_X0110);
        SkinManager.setViewTextColor(this.B, R.color.CAM_X0110);
        int i3 = this.C;
        if (i3 == 0 || (lineCountNotifyTextView = this.t) == null) {
            return;
        }
        SkinManager.setViewTextColor(lineCountNotifyTextView, i3, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: P */
    public void y(OnePicInfoCard onePicInfoCard) {
        this.s.V(!TextUtils.isEmpty(onePicInfoCard.getPic()) ? onePicInfoCard.getPic() : null, 10, false);
        if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
            this.t.setText(onePicInfoCard.getCardTitle());
            this.t.setGetLineCountCallback(new a(onePicInfoCard));
        }
        if (StringUtils.isNull(onePicInfoCard.getTag())) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
            setTagBg(onePicInfoCard);
            this.v.setText(onePicInfoCard.getTag());
        }
        if (onePicInfoCard.getIconList() != null) {
            this.w.setVisibility(8);
            this.z.setVisibility(8);
            if (onePicInfoCard.getIconList().size() > 0) {
                this.w.setVisibility(0);
                N(this.y, this.x, onePicInfoCard.getIconList().get(0));
            }
            if (onePicInfoCard.getIconList().size() > 1) {
                this.z.setVisibility(0);
                N(this.B, this.A, onePicInfoCard.getIconList().get(1));
            }
        } else {
            this.w.setVisibility(8);
            this.z.setVisibility(8);
        }
        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(String.valueOf(onePicInfoCard.getItemId()))) {
            this.C = R.color.CAM_X0108;
        } else {
            this.C = R.color.CAM_X0105;
        }
        SkinManager.setViewTextColor(this.t, this.C, 1);
        setCardOnClickListener(new b(onePicInfoCard));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: Q */
    public void z(OnePicInfoCard onePicInfoCard) {
        i.e(onePicInfoCard).d(TiebaStatic.Params.OBJ_URL, onePicInfoCard.getScheme()).b("obj_locate", getStatPosition()).a(onePicInfoCard);
        super.z(onePicInfoCard);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View u() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_one_pic_info, (ViewGroup) null);
        this.r = viewGroup;
        this.s = (TbImageView) o(viewGroup, R.id.img);
        this.t = (LineCountNotifyTextView) o(this.r, R.id.one_title);
        this.u = (TextView) o(this.r, R.id.discription);
        View view = (View) o(this.r, R.id.hot_thread_comment);
        this.v = (TextView) o(view, R.id.hot_thread_line_tag);
        this.w = (LinearLayout) o(view, R.id.ll_left);
        this.x = (TbImageView) o(view, R.id.iconLeft);
        this.y = (TextView) o(view, R.id.textLeft);
        this.z = (LinearLayout) o(view, R.id.ll_right);
        this.A = (TbImageView) o(view, R.id.iconRight);
        this.B = (TextView) o(view, R.id.textRight);
        return this.r;
    }
}
