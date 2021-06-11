package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.m0.r.f0.m.b;
import d.a.m0.r.u.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR.\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/PbVideoDetailBrowseModeEmotionHolder;", "com/baidu/adp/widget/ListView/TypeAdapter$ViewHolder", "", "onChangeSkinType", "()V", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "agreeBtn", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "descriptionText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "Lcom/baidu/adp/newwidget/ImageView/BDImageView;", "emotionImg", "Lcom/baidu/adp/newwidget/ImageView/BDImageView;", "Landroid/view/View$OnClickListener;", "value", "onAgreeListener", "Landroid/view/View$OnClickListener;", "getOnAgreeListener", "()Landroid/view/View$OnClickListener;", "setOnAgreeListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "pb_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class PbVideoDetailBrowseModeEmotionHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final BDImageView f19221a;

    /* renamed from: b  reason: collision with root package name */
    public final EMTextView f19222b;

    /* renamed from: c  reason: collision with root package name */
    public final TBSpecificationBtn f19223c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f19224d;

    public PbVideoDetailBrowseModeEmotionHolder(View view) {
        super(view);
        View findViewById = a().findViewById(R.id.emotion_img);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "getView().findViewById(R.id.emotion_img)");
        this.f19221a = (BDImageView) findViewById;
        View findViewById2 = a().findViewById(R.id.description_text);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "getView().findViewById(R.id.description_text)");
        this.f19222b = (EMTextView) findViewById2;
        View findViewById3 = a().findViewById(R.id.agree_btn);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "getView().findViewById(R.id.agree_btn)");
        this.f19223c = (TBSpecificationBtn) findViewById3;
        SkinManager.setImageResource(this.f19221a, R.drawable.new_pic_emotion_01);
        this.f19222b.setText(R.string.pb_video_detail_browse_mode_description);
        c.d(this.f19222b).s(R.color.CAM_X0107);
        b bVar = new b();
        bVar.o(R.color.CAM_X0303, R.color.CAM_X0101);
        this.f19223c.setConfig(bVar);
        this.f19223c.setText(TbadkCoreApplication.getInst().getString(R.string.pb_video_detail_browse_mode_agree_btn));
        this.f19223c.setTextSize(R.dimen.T_X07);
    }

    public final void b() {
        SkinManager.setImageResource(this.f19221a, R.drawable.new_pic_emotion_01);
        c.d(this.f19222b).s(R.color.CAM_X0107);
        this.f19223c.k();
    }

    public final void c(View.OnClickListener onClickListener) {
        this.f19224d = onClickListener;
        if (onClickListener != null) {
            this.f19223c.setOnClickListener(onClickListener);
        }
    }
}
