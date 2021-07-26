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
/* loaded from: classes4.dex */
public class SearchSuggestForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f18504a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f18505b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f18506c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18507d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18508e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18509f;

    /* renamed from: g  reason: collision with root package name */
    public View f18510g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSuggestForumViewHolder(View view) {
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
        this.f18504a = view.findViewById(R.id.rootview);
        this.f18505b = (TbImageView) view.findViewById(R.id.search_forum_bar_icon);
        this.f18506c = (TextView) view.findViewById(R.id.search_forum_title);
        this.f18507d = (TextView) view.findViewById(R.id.search_forum_introduce);
        this.f18508e = (TextView) view.findViewById(R.id.search_forum_attention_content);
        this.f18509f = (TextView) view.findViewById(R.id.search_forum_pb_content);
        this.f18510g = view.findViewById(R.id.search_sugget_line);
    }
}
