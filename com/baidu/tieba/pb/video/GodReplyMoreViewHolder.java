package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import c.a.s0.s2.f;
import c.a.s0.s2.h;
import c.a.s0.s2.i;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class GodReplyMoreViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View dividerLine;
    public TextView moreView;
    public int skinType;

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
        this.skinType = 3;
        this.moreView = (TextView) view.findViewById(i.look_more_view);
        this.dividerLine = view.findViewById(i.divider_line_above_more_god_replays);
        SkinManager.setViewTextColor(this.moreView, f.CAM_X0106);
        SkinManager.setBackgroundResource(this.moreView, h.more_all);
        SkinManager.setBackgroundResource(this.dividerLine, f.CAM_X0204);
    }
}
