package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.pe9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AppDownloadView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ProgressBar b;
    public ImageView c;
    public TextView d;
    public DownloadData e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SkinManager.setViewTextColor(this.a, R.color.CAM_X0108, 1, i);
            this.b.setProgressDrawable(SkinManager.getDrawable(i, (int) R.drawable.progress_download_app_layerlist));
            SkinManager.setImageResource(this.c, R.drawable.icon_download_play, i);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0109, 1, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }

    public static int getStatus(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, downloadData)) == null) {
            return pe9.p(downloadData);
        }
        return invokeL.intValue;
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            int max = Math.max(0, i);
            this.b.setProgress(max);
            TextView textView = this.d;
            textView.setText(max + "%");
        }
    }

    public void refreshControlIcon(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i == 1) {
                SkinManager.setImageResource(this.c, R.drawable.icon_download_pause);
            } else {
                SkinManager.setImageResource(this.c, R.drawable.icon_download_play);
            }
        }
    }

    public void setData(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, downloadData) != null) || downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.e = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        b(downloadData);
    }

    public void showTitleView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.setVisibility(i);
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(0);
            setGravity(16);
            View inflate = LayoutInflater.from(context).inflate(R.layout.app_download_layout, (ViewGroup) this, true);
            this.a = (TextView) inflate.findViewById(R.id.app_push_title);
            this.b = (ProgressBar) inflate.findViewById(R.id.frs_app_push_progress);
            this.c = (ImageView) inflate.findViewById(R.id.frs_app_push_control);
            this.d = (TextView) inflate.findViewById(R.id.frs_app_push_percent);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void b(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) != null) || downloadData == null) {
            return;
        }
        int status = downloadData.getStatus();
        if (status != 1) {
            if (status != 3) {
                if (status != 5) {
                    if (status != 6) {
                        if (status == 7) {
                            setVisibility(0);
                            SkinManager.setImageResource(this.c, R.drawable.icon_download_play);
                        }
                    } else {
                        setVisibility(8);
                    }
                } else {
                    setVisibility(0);
                }
            } else {
                setVisibility(8);
            }
        } else {
            setVisibility(0);
            SkinManager.setImageResource(this.c, R.drawable.icon_download_pause);
        }
        int j = pe9.n().j(downloadData.getId(), downloadData.getName());
        if (j >= 0) {
            c(j);
        } else {
            c(0);
        }
    }
}
