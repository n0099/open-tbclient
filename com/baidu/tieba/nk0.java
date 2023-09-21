package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.crius.uiwidget.ApkDownloadView;
import com.baidu.nadcore.crius.uiwidget.JumpButton;
import com.baidu.nadcore.crius.uiwidget.SyncTextView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.data.RenderData;
import com.baidu.searchbox.crius.factory.IComponentFactory;
import com.baidu.searchbox.crius.util.ColorUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nk0 implements IComponentFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nk0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.crius.factory.IComponentFactory
    public View createComponent(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (!NativeConstants.COMPONENT_CLOSEAD.equalsIgnoreCase(str) && !"close".equalsIgnoreCase(str)) {
                if (NativeConstants.COMPONENT_VIEWBTN.equalsIgnoreCase(str)) {
                    return new JumpButton(context);
                }
                if ("download".equalsIgnoreCase(str)) {
                    return new ApkDownloadView(context);
                }
                if (NativeConstants.COMPONENT_SYNC_TEXT_VIEW.equalsIgnoreCase(str)) {
                    return new SyncTextView(context);
                }
                return null;
            }
            ImageView imageView = new ImageView(context);
            imageView.setId(R.id.nad_base_delete_id);
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.nad_pop_close_btn));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setContentDescription("不感兴趣");
            return imageView;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.crius.factory.IComponentFactory
    public boolean renderComponent(String str, View view2, RenderData renderData, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, view2, renderData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (renderData == null) {
                return false;
            }
            if (!NativeConstants.COMPONENT_CLOSEAD.equalsIgnoreCase(str) && !"close".equalsIgnoreCase(str)) {
                if (view2 instanceof JumpButton) {
                    ((JumpButton) view2).setText(renderData.text);
                    return true;
                } else if (view2 instanceof ApkDownloadView) {
                    ApkDownloadView apkDownloadView = (ApkDownloadView) view2;
                    apkDownloadView.setDownloadStyle(renderData.downloadStyle);
                    apkDownloadView.setTextSize(renderData.fontSize);
                    apkDownloadView.setTextColor(ColorUtils.getColorRes(z, renderData.colorNight, renderData.color));
                    apkDownloadView.setProgressColor(ColorUtils.getColorRes(z, renderData.progressNightColor, renderData.progressColor));
                    apkDownloadView.setStrokeWidth(renderData.strokeWidth);
                    apkDownloadView.setStrokeColor(ColorUtils.getColorRes(z, renderData.strokeNightColor, renderData.strokeColor));
                    apkDownloadView.setBorderRadius(renderData.borderRadius);
                    RenderData.BackgroundData backgroundData = renderData.backgroundData;
                    if (backgroundData != null) {
                        if (z) {
                            str2 = backgroundData.backgroundColorNight;
                        } else {
                            str2 = backgroundData.backgroundColor;
                        }
                        apkDownloadView.setBackgroundColor(ColorUtils.parseColor(str2));
                    }
                    return true;
                } else if (!(view2 instanceof SyncTextView)) {
                    return false;
                } else {
                    ((SyncTextView) view2).update(renderData, z, z3);
                    return true;
                }
            }
            ImageView imageView = (ImageView) view2;
            imageView.setImageDrawable(view2.getResources().getDrawable(R.drawable.nad_pop_close_btn));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
