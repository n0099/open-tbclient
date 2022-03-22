package com.baidu.tieba.newinterest.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class InterestedForumStyleAForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f34786b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34787c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34788d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34789e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34790f;

    /* renamed from: g  reason: collision with root package name */
    public View f34791g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34792h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestedForumStyleAForumViewHolder(View view) {
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
        this.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090f2f);
        this.f34786b = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090f2b);
        this.f34787c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f31);
        this.f34788d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f2c);
        this.f34789e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f29);
        this.f34790f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f2e);
        this.f34791g = view.findViewById(R.id.obfuscated_res_0x7f090f2a);
        this.f34792h = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090f30);
    }
}
