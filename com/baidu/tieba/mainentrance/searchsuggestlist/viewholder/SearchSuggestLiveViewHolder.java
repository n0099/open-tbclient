package com.baidu.tieba.mainentrance.searchsuggestlist.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SearchSuggestLiveViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f18518a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f18519b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f18520c;

    /* renamed from: d  reason: collision with root package name */
    public TBLottieAnimationView f18521d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f18522e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18523f;

    /* renamed from: g  reason: collision with root package name */
    public View f18524g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestLiveViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18518a = view.findViewById(R.id.rootview);
        this.f18519b = (TextView) view.findViewById(R.id.search_suggest_title);
        this.f18520c = (ImageView) view.findViewById(R.id.search_bar_icon);
        this.f18521d = (TBLottieAnimationView) view.findViewById(R.id.search_live_lottie);
        this.f18522e = (FrameLayout) view.findViewById(R.id.search_live_layout);
        this.f18523f = (TextView) view.findViewById(R.id.living_text);
        this.f18524g = view.findViewById(R.id.search_sugget_line);
    }
}
