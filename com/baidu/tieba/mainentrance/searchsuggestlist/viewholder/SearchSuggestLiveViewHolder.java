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
/* loaded from: classes5.dex */
public class SearchSuggestLiveViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34368b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34369c;

    /* renamed from: d  reason: collision with root package name */
    public TBLottieAnimationView f34370d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f34371e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34372f;

    /* renamed from: g  reason: collision with root package name */
    public View f34373g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestLiveViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view.findViewById(R.id.obfuscated_res_0x7f091aef);
        this.f34368b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091c48);
        this.f34369c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091c1c);
        this.f34370d = (TBLottieAnimationView) view.findViewById(R.id.obfuscated_res_0x7f091c3c);
        this.f34371e = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f091c3b);
        this.f34372f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0912dd);
        this.f34373g = view.findViewById(R.id.obfuscated_res_0x7f091c49);
    }
}
