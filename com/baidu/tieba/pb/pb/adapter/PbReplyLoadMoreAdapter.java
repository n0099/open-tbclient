package com.baidu.tieba.pb.pb.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.r0.k2.f;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.u.f.n;
import b.a.r0.k2.y.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbReplyLoadMoreAdapter extends n<PostData, ReplyLoadMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;

    /* loaded from: classes9.dex */
    public static class ReplyLoadMoreViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f52131a;

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
            this.f52131a = (TextView) view.findViewById(i.tv_pb_reply_more);
        }

        public void onChangeSkin() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setViewTextColor(this.f52131a, f.CAM_X0109);
            }
        }

        public void setData(PostData postData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) || postData == null) {
                return;
            }
            if (postData.F) {
                Drawable drawable = SkinManager.getDrawable(h.icon_emotion_smallarrow_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f52131a.setCompoundDrawables(null, null, drawable, null);
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(h.icon_emotion_smallarrow_down);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.f52131a.setCompoundDrawables(null, null, drawable2, null);
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
    @Override // b.a.e.l.e.a
    /* renamed from: i0 */
    public ReplyLoadMoreViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f2419e).inflate(j.pb_reply_load_more_item, viewGroup, false);
            inflate.findViewById(i.tv_pb_reply_more).setOnClickListener(this.s);
            ReplyLoadMoreViewHolder replyLoadMoreViewHolder = new ReplyLoadMoreViewHolder(inflate);
            replyLoadMoreViewHolder.onChangeSkin();
            return replyLoadMoreViewHolder;
        }
        return (ReplyLoadMoreViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.k2.u.f.n, b.a.e.l.e.a
    /* renamed from: j0 */
    public View Z(int i2, View view, ViewGroup viewGroup, PostData postData, ReplyLoadMoreViewHolder replyLoadMoreViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, replyLoadMoreViewHolder})) == null) {
            replyLoadMoreViewHolder.setData(postData);
            return replyLoadMoreViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
