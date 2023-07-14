package com.baidu.tieba;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class os8 implements AdapterView.OnItemLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final MsgChatCenterSliceView b;
    public final MessageAggregationListAdapter c;

    public os8(TbPageContext<BaseFragmentActivity> pageContext, MsgChatCenterSliceView sliceView, MessageAggregationListAdapter messageAggregationListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, sliceView, messageAggregationListAdapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(sliceView, "sliceView");
        this.a = pageContext;
        this.b = sliceView;
        this.c = messageAggregationListAdapter;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.c;
            if (messageAggregationListAdapter != null) {
                imMessageCenterShowItemData = messageAggregationListAdapter.getItem(i);
            } else {
                imMessageCenterShowItemData = null;
            }
            if (i < 0 || imMessageCenterShowItemData == null) {
                return false;
            }
            if (imMessageCenterShowItemData.getDataType() == 2) {
                return true;
            }
            if (!this.b.s0(imMessageCenterShowItemData)) {
                if (adapterView != null) {
                    adapterView.setHapticFeedbackEnabled(false);
                }
                return true;
            }
            TiebaStatic.log("c12932");
            y55 b0 = this.b.b0();
            if (b0 != null) {
                b0.l();
            }
            if (this.a.getPageActivity() != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.a.getPageActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
