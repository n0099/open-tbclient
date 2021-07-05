package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GodReplyMoreViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f19632a;

    /* renamed from: b  reason: collision with root package name */
    public View f19633b;

    /* renamed from: c  reason: collision with root package name */
    public int f19634c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodReplyMoreViewHolder(View view) {
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
        this.f19634c = 3;
        this.f19632a = (TextView) view.findViewById(R.id.look_more_view);
        this.f19633b = view.findViewById(R.id.divider_line_above_more_god_replays);
        SkinManager.setViewTextColor(this.f19632a, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.f19632a, R.drawable.more_all);
        SkinManager.setBackgroundResource(this.f19633b, R.color.CAM_X0204);
    }
}
