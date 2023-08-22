package com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter.holder;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.go8;
import com.baidu.tieba.ho8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.EmojiGridView;
import com.baidu.tieba.ko8;
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
    public EmojiGroupVH(@NonNull View view2, @NonNull ko8 ko8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, ko8Var};
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
        this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909a5);
        EmojiGridView emojiGridView = (EmojiGridView) view2.findViewById(R.id.obfuscated_res_0x7f0909a4);
        this.b = emojiGridView;
        emojiGridView.setNumColumns(go8.a());
        ho8 ho8Var = new ho8(view2.getContext());
        ho8Var.c(ko8Var);
        this.b.setAdapter((ListAdapter) ho8Var);
    }
}
