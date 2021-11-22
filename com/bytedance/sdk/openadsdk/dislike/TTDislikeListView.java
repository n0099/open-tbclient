package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeController;
/* loaded from: classes11.dex */
public class TTDislikeListView extends ListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TTDislikeController mDislikeController;
    public AdapterView.OnItemClickListener mOnItemClickListener;
    public AdapterView.OnItemClickListener mOnItemClickListenerInner;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTDislikeListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTDislikeListView f62598a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f62598a = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i4), Long.valueOf(j)}) == null) {
                    if (this.f62598a.getAdapter() != null && this.f62598a.getAdapter().getItem(i4) != null && (this.f62598a.getAdapter().getItem(i4) instanceof FilterWord)) {
                        FilterWord filterWord = (FilterWord) this.f62598a.getAdapter().getItem(i4);
                        if (filterWord.hasSecondOptions()) {
                            return;
                        }
                        if (this.f62598a.mDislikeController != null) {
                            this.f62598a.mDislikeController.onDislikeSelected(filterWord);
                        }
                        if (this.f62598a.mOnItemClickListener != null) {
                            this.f62598a.mOnItemClickListener.onItemClick(adapterView, view, i4, j);
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
            }
        };
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            super.setOnItemClickListener(this.mOnItemClickListenerInner);
        }
    }

    public void setDislikeInfo(TTDislikeController tTDislikeController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tTDislikeController) == null) {
            this.mDislikeController = tTDislikeController;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onItemClickListener) == null) {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTDislikeListView f62598a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f62598a = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i4), Long.valueOf(j)}) == null) {
                    if (this.f62598a.getAdapter() != null && this.f62598a.getAdapter().getItem(i4) != null && (this.f62598a.getAdapter().getItem(i4) instanceof FilterWord)) {
                        FilterWord filterWord = (FilterWord) this.f62598a.getAdapter().getItem(i4);
                        if (filterWord.hasSecondOptions()) {
                            return;
                        }
                        if (this.f62598a.mDislikeController != null) {
                            this.f62598a.mDislikeController.onDislikeSelected(filterWord);
                        }
                        if (this.f62598a.mOnItemClickListener != null) {
                            this.f62598a.mOnItemClickListener.onItemClick(adapterView, view, i4, j);
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
            }
        };
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTDislikeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTDislikeListView f62598a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f62598a = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i42, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i42), Long.valueOf(j)}) == null) {
                    if (this.f62598a.getAdapter() != null && this.f62598a.getAdapter().getItem(i42) != null && (this.f62598a.getAdapter().getItem(i42) instanceof FilterWord)) {
                        FilterWord filterWord = (FilterWord) this.f62598a.getAdapter().getItem(i42);
                        if (filterWord.hasSecondOptions()) {
                            return;
                        }
                        if (this.f62598a.mDislikeController != null) {
                            this.f62598a.mDislikeController.onDislikeSelected(filterWord);
                        }
                        if (this.f62598a.mOnItemClickListener != null) {
                            this.f62598a.mOnItemClickListener.onItemClick(adapterView, view, i42, j);
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
            }
        };
        init();
    }
}
