package com.baidu.tieba.view.headcard.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.n6b;
import com.baidu.tieba.r6b;
import com.baidu.tieba.view.headcard.compete.CompeteCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/tieba/view/headcard/viewholder/MatchCompeteCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mView", "Lcom/baidu/tieba/view/headcard/compete/CompeteCardView;", "(Lcom/baidu/tieba/view/headcard/compete/CompeteCardView;)V", "bindView", "", "data", "Lcom/baidu/tieba/view/headcard/data/HeadQuizCardData;", "isFromFrs", "", "fid", "", ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MatchCompeteCardViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CompeteCardView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchCompeteCardViewHolder(CompeteCardView mView) {
        super(mView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mView};
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
        Intrinsics.checkNotNullParameter(mView, "mView");
        this.a = mView;
    }

    public final void a(n6b n6bVar, boolean z, String str, String str2) {
        r6b r6bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{n6bVar, Boolean.valueOf(z), str, str2}) == null) {
            if (n6bVar != null) {
                r6bVar = n6bVar.d();
            } else {
                r6bVar = null;
            }
            if (r6bVar == null) {
                return;
            }
            this.a.t(n6bVar, z, str, str2);
        }
    }
}
