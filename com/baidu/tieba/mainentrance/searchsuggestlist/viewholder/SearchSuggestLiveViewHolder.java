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
    public TextView b;
    public ImageView c;
    public TBLottieAnimationView d;
    public FrameLayout e;
    public TextView f;
    public View g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestLiveViewHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.a = view2.findViewById(R.id.obfuscated_res_0x7f091e34);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fc0);
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091f90);
        this.d = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f091fb1);
        this.e = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091fb0);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091549);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f091fc1);
    }
}
