package com.baidu.tieba.mainentrance.searchsuggestlist.viewholder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SearchSuggestForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public TextView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestForumViewHolder(View view2) {
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
        this.a = view2.findViewById(R.id.obfuscated_res_0x7f091f6b);
        this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0920d7);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920db);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920d9);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920d6);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920da);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f0920fd);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920d8);
    }
}
