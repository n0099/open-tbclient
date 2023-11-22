package com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter.holder;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.EmojiGridView;
import com.baidu.tieba.w09;
import com.baidu.tieba.xv8;
import com.baidu.tieba.y09;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class EmojiGroupVH extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public EmojiGridView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiGroupVH(@NonNull View view2, @NonNull y09 y09Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, y09Var};
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
        this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909d1);
        EmojiGridView emojiGridView = (EmojiGridView) view2.findViewById(R.id.obfuscated_res_0x7f0909d0);
        this.b = emojiGridView;
        emojiGridView.setNumColumns(xv8.a());
        w09 w09Var = new w09(view2.getContext());
        w09Var.c(y09Var);
        this.b.setAdapter((ListAdapter) w09Var);
    }
}
