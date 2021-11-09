package com.baidu.tieba.recapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.q.c;
import b.a.r0.z2.l0.e;
import b.a.r0.z2.l0.g;
import b.a.r0.z2.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AdAppInfoView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f53621e;

    /* renamed from: f  reason: collision with root package name */
    public int f53622f;

    /* renamed from: g  reason: collision with root package name */
    public int f53623g;
    public c mAdInfoModel;
    public TextView mAdTagView;
    public TextView mAppName;
    public TextView mAuthorNameView;
    public View.OnClickListener mClickListener;
    public RelativeLayout mDownloadButtonContainer;
    public TextView mPermissionTagView;
    public TextView mPrivacyTagView;
    public AdStarRatingBar mRatingBar;
    public TextView mVersionView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdAppInfoView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SimpleAdInfoView);
        this.f53622f = obtainStyledAttributes.getResourceId(R$styleable.SimpleAdInfoView_layoutId, this.f53622f);
        obtainStyledAttributes.recycle();
    }

    public final void b() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (viewTreeObserver = this.mAuthorNameView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, viewTreeObserver) { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver f53625e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ AdAppInfoView f53626f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, viewTreeObserver};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53626f = this;
                this.f53625e = viewTreeObserver;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Layout layout = this.f53626f.mAuthorNameView.getLayout();
                    if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        AdAppInfoView adAppInfoView = this.f53626f;
                        adAppInfoView.mAuthorNameView.setOnClickListener(adAppInfoView.mClickListener);
                    }
                    if (this.f53625e.isAlive()) {
                        this.f53625e.removeOnGlobalLayoutListener(this);
                    }
                }
            }
        });
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f53621e == null || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.r0.z2.l0.c b2 = g.b(this.f53621e, 102, 0);
        b2.c(str);
        e.b().d(b2);
    }

    public RelativeLayout getDownloadButtonContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDownloadButtonContainer : (RelativeLayout) invokeV.objValue;
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53622f : invokeV.intValue;
    }

    public void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, attributeSet) == null) {
            setLayoutByAttrs(attributeSet);
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
            this.mAppName = (TextView) findViewById(R.id.ad_name);
            this.mRatingBar = (AdStarRatingBar) findViewById(R.id.ad_rating);
            this.mVersionView = (TextView) findViewById(R.id.ad_version);
            this.mAuthorNameView = (TextView) findViewById(R.id.ad_author_full_name);
            this.mPrivacyTagView = (TextView) findViewById(R.id.ad_privacy);
            this.mPermissionTagView = (TextView) findViewById(R.id.ad_permission);
            this.mAdTagView = (TextView) findViewById(R.id.ad_tag);
            this.mDownloadButtonContainer = (RelativeLayout) findViewById(R.id.download_button_container);
            this.mPrivacyTagView.setOnClickListener(this.mClickListener);
            this.mPermissionTagView.setOnClickListener(this.mClickListener);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.mAppName, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.mVersionView, this.f53623g);
            SkinManager.setViewTextColor(this.mAuthorNameView, this.f53623g);
            SkinManager.setViewTextColor(this.mPrivacyTagView, this.f53623g);
            SkinManager.setViewTextColor(this.mPermissionTagView, this.f53623g);
            this.mRatingBar.onChangeSkinType();
        }
    }

    public void setAd(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            this.f53621e = advertAppInfo;
        }
    }

    public void setAppInfo(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            if (cVar != null && c.c(cVar)) {
                this.mAdInfoModel = cVar;
                if (this.mAppName != null) {
                    if (!TextUtils.isEmpty(cVar.f13240c)) {
                        this.mAppName.setVisibility(0);
                        this.mAppName.setText(cVar.f13240c);
                    } else {
                        this.mAppName.setVisibility(8);
                    }
                }
                AdStarRatingBar adStarRatingBar = this.mRatingBar;
                if (adStarRatingBar != null) {
                    float f2 = cVar.f13242e;
                    if (f2 >= 0.0f && f2 <= 5.0f) {
                        adStarRatingBar.setVisibility(0);
                        this.mRatingBar.setRating(cVar.f13242e);
                    } else {
                        this.mRatingBar.setVisibility(8);
                    }
                }
                if (this.mVersionView != null) {
                    if (!TextUtils.isEmpty(cVar.f13243f)) {
                        this.mVersionView.setVisibility(0);
                        this.mVersionView.setText(cVar.f13243f);
                    } else {
                        this.mVersionView.setVisibility(8);
                    }
                }
                if (this.mAuthorNameView != null) {
                    if (!TextUtils.isEmpty(cVar.f13241d)) {
                        this.mAuthorNameView.setVisibility(0);
                        this.mAuthorNameView.setText(cVar.f13241d);
                        b();
                    } else {
                        this.mAuthorNameView.setVisibility(8);
                    }
                }
                if (this.mPrivacyTagView != null) {
                    c.b bVar = cVar.f13244g;
                    if (bVar != null && !TextUtils.isEmpty(bVar.f13250b) && !TextUtils.isEmpty(cVar.f13244g.f13249a)) {
                        this.mPrivacyTagView.setVisibility(0);
                        this.mPrivacyTagView.setText(cVar.f13244g.f13249a);
                    } else {
                        this.mPrivacyTagView.setVisibility(8);
                    }
                }
                if (this.mPrivacyTagView != null) {
                    c.a aVar = cVar.f13245h;
                    if (aVar != null && !TextUtils.isEmpty(aVar.f13248b) && !TextUtils.isEmpty(cVar.f13245h.f13247a)) {
                        this.mPermissionTagView.setVisibility(0);
                        this.mPermissionTagView.setText(cVar.f13245h.f13247a);
                    } else {
                        this.mPermissionTagView.setVisibility(8);
                    }
                }
                TextView textView = this.mAdTagView;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                }
                return;
            }
            this.mAdInfoModel = null;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f53623g = i2;
            this.mRatingBar.setTextColor(i2);
        }
    }

    public void setTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mRatingBar.setTextSize(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAppInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f53622f = R.layout.ad_app_info_view;
        this.f53623g = R.color.CAM_X0109;
        this.mClickListener = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdAppInfoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdAppInfoView f53624e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f53624e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f53624e.mAdInfoModel == null) {
                    return;
                }
                int id = view.getId();
                String str2 = "";
                if (id == R.id.ad_privacy) {
                    c.b bVar = this.f53624e.mAdInfoModel.f13244g;
                    if (bVar != null) {
                        str2 = bVar.f13250b;
                        str = "app_privacy";
                    }
                    str = "";
                } else {
                    if (id == R.id.ad_permission) {
                        c.a aVar = this.f53624e.mAdInfoModel.f13245h;
                        if (aVar != null) {
                            str2 = aVar.f13248b;
                            str = "app_permission";
                        }
                    } else if (id == R.id.ad_author_full_name) {
                        l.M(this.f53624e.getContext(), this.f53624e.mAdInfoModel.f13241d);
                        return;
                    }
                    str = "";
                }
                z.d(this.f53624e.getContext(), str2, null, null);
                this.f53624e.c(str);
            }
        };
        init(attributeSet);
    }
}
