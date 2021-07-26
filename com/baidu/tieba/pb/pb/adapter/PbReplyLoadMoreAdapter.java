package com.baidu.tieba.pb.pb.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.h2.k.e.o;
import d.a.q0.h2.o.b;
/* loaded from: classes4.dex */
public class PbReplyLoadMoreAdapter extends o<PostData, ReplyLoadMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
    public static class ReplyLoadMoreViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f19246a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplyLoadMoreViewHolder(View view) {
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
            this.f19246a = (TextView) view.findViewById(R.id.tv_pb_reply_more);
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setViewTextColor(this.f19246a, R.color.CAM_X0109);
            }
        }

        public void c(PostData postData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) || postData == null) {
                return;
            }
            if (postData.D) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_smallarrow_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f19246a.setCompoundDrawables(null, null, drawable, null);
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_emotion_smallarrow_down);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f19246a.setCompoundDrawables(null, null, drawable2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbReplyLoadMoreAdapter(b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public ReplyLoadMoreViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f42341e).inflate(R.layout.pb_reply_load_more_item, viewGroup, false);
            inflate.findViewById(R.id.tv_pb_reply_more).setOnClickListener(this.s);
            ReplyLoadMoreViewHolder replyLoadMoreViewHolder = new ReplyLoadMoreViewHolder(inflate);
            replyLoadMoreViewHolder.b();
            return replyLoadMoreViewHolder;
        }
        return (ReplyLoadMoreViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.h2.k.e.o, d.a.d.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, PostData postData, ReplyLoadMoreViewHolder replyLoadMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, replyLoadMoreViewHolder})) == null) {
            replyLoadMoreViewHolder.c(postData);
            return replyLoadMoreViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
