package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.dislike.c.b;
/* loaded from: classes5.dex */
public class TTDislikeListView extends ListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f31190a;

    /* renamed from: b  reason: collision with root package name */
    public AdapterView.OnItemClickListener f31191b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f31192c;

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
        this.f31192c = new AdapterView.OnItemClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTDislikeListView f31193a;

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
                this.f31193a = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i4), Long.valueOf(j)}) == null) {
                    if (this.f31193a.getAdapter() != null && this.f31193a.getAdapter().getItem(i4) != null && (this.f31193a.getAdapter().getItem(i4) instanceof FilterWord)) {
                        FilterWord filterWord = (FilterWord) this.f31193a.getAdapter().getItem(i4);
                        if (filterWord.hasSecondOptions()) {
                            return;
                        }
                        if (this.f31193a.f31190a != null) {
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f31193a.f31190a, filterWord);
                        }
                        if (this.f31193a.f31191b != null) {
                            this.f31193a.f31191b.onItemClick(adapterView, view, i4, j);
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
            }
        };
        a();
    }

    public void setDislikeInfo(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f31190a = bVar;
        }
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onItemClickListener) == null) {
            this.f31191b = onItemClickListener;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            super.setOnItemClickListener(this.f31192c);
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
        this.f31192c = new AdapterView.OnItemClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTDislikeListView f31193a;

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
                this.f31193a = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i4), Long.valueOf(j)}) == null) {
                    if (this.f31193a.getAdapter() != null && this.f31193a.getAdapter().getItem(i4) != null && (this.f31193a.getAdapter().getItem(i4) instanceof FilterWord)) {
                        FilterWord filterWord = (FilterWord) this.f31193a.getAdapter().getItem(i4);
                        if (filterWord.hasSecondOptions()) {
                            return;
                        }
                        if (this.f31193a.f31190a != null) {
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f31193a.f31190a, filterWord);
                        }
                        if (this.f31193a.f31191b != null) {
                            this.f31193a.f31191b.onItemClick(adapterView, view, i4, j);
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
            }
        };
        a();
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
        this.f31192c = new AdapterView.OnItemClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTDislikeListView f31193a;

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
                this.f31193a = this;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i42, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i42), Long.valueOf(j)}) == null) {
                    if (this.f31193a.getAdapter() != null && this.f31193a.getAdapter().getItem(i42) != null && (this.f31193a.getAdapter().getItem(i42) instanceof FilterWord)) {
                        FilterWord filterWord = (FilterWord) this.f31193a.getAdapter().getItem(i42);
                        if (filterWord.hasSecondOptions()) {
                            return;
                        }
                        if (this.f31193a.f31190a != null) {
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f31193a.f31190a, filterWord);
                        }
                        if (this.f31193a.f31191b != null) {
                            this.f31193a.f31191b.onItemClick(adapterView, view, i42, j);
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
            }
        };
        a();
    }
}
