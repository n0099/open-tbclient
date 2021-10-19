package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.z2.f0.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class AppDownloadView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56557e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f56558f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56559g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56560h;

    /* renamed from: i  reason: collision with root package name */
    public DownloadData f56561i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f56562j;
    public CustomMessageListener k;

    /* loaded from: classes7.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AppDownloadView f56565e;

        public AppDownloadListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, appDownloadView) == null) {
                this.f56565e = appDownloadView;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f56562j = null;
        this.k = null;
        d(context);
    }

    public static int getStatus(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, downloadData)) == null) ? e.p(downloadData) : invokeL.intValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(0);
            setGravity(16);
            View inflate = LayoutInflater.from(context).inflate(R.layout.app_download_layout, (ViewGroup) this, true);
            this.f56557e = (TextView) inflate.findViewById(R.id.app_push_title);
            this.f56558f = (ProgressBar) inflate.findViewById(R.id.frs_app_push_progress);
            this.f56559g = (ImageView) inflate.findViewById(R.id.frs_app_push_control);
            this.f56560h = (TextView) inflate.findViewById(R.id.frs_app_push_percent);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void e(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null) {
            return;
        }
        int status = downloadData.getStatus();
        if (status == 1) {
            setVisibility(0);
            SkinManager.setImageResource(this.f56559g, R.drawable.icon_download_pause);
        } else if (status == 3) {
            setVisibility(8);
        } else if (status == 5) {
            setVisibility(0);
        } else if (status == 6) {
            setVisibility(8);
        } else if (status == 7) {
            setVisibility(0);
            SkinManager.setImageResource(this.f56559g, R.drawable.icon_download_play);
        }
        int j2 = e.n().j(downloadData.getId(), downloadData.getName());
        if (j2 >= 0) {
            h(j2);
        } else {
            h(0);
        }
    }

    public void enableDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f56562j == null) {
                this.f56562j = new CustomMessageListener(this, 2001118) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AppDownloadView f56563a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f56563a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage) && this.f56563a.f56561i != null) {
                            DownloadData downloadData = null;
                            List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= data.size()) {
                                    break;
                                }
                                DownloadData downloadData2 = data.get(i2);
                                if (TextUtils.isEmpty(this.f56563a.f56561i.getId())) {
                                    i2++;
                                } else if (this.f56563a.f56561i.getId().equals(downloadData2.getId())) {
                                    downloadData = downloadData2;
                                }
                            }
                            if (downloadData != null) {
                                this.f56563a.h(e.n().j(downloadData.getId(), downloadData.getName()));
                                this.f56563a.postInvalidate();
                            }
                        }
                    }
                };
            }
            if (this.k == null) {
                this.k = new CustomMessageListener(this, 2016484) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AppDownloadView f56564a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f56564a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f56564a.f56561i == null) {
                            return;
                        }
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (this.f56564a.f56561i.getId() == null || downloadData == null || !this.f56564a.f56561i.getId().equals(downloadData.getId())) {
                            return;
                        }
                        int p = e.p(downloadData);
                        if (p == 7) {
                            SkinManager.setImageResource(this.f56564a.f56559g, R.drawable.icon_download_pause);
                        } else if (p == 1) {
                            SkinManager.setImageResource(this.f56564a.f56559g, R.drawable.icon_download_play);
                        }
                    }
                };
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f56562j != null) {
                MessageManager.getInstance().registerListener(this.f56562j);
            }
            if (this.k != null) {
                MessageManager.getInstance().registerListener(this.k);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f56562j != null) {
                MessageManager.getInstance().unRegisterListener(this.f56562j);
            }
            if (this.k != null) {
                MessageManager.getInstance().unRegisterListener(this.k);
            }
        }
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int max = Math.max(0, i2);
            this.f56558f.setProgress(max);
            TextView textView = this.f56560h;
            textView.setText(max + "%");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            f();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setViewTextColor(this.f56557e, R.color.CAM_X0108, 1, i2);
            this.f56558f.setProgressDrawable(SkinManager.getDrawable(i2, R.drawable.progress_download_app_layerlist));
            SkinManager.setImageResource(this.f56559g, R.drawable.icon_download_play, i2);
            SkinManager.setViewTextColor(this.f56560h, R.color.CAM_X0109, 1, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            g();
        }
    }

    public void refreshControlIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 == 1) {
                SkinManager.setImageResource(this.f56559g, R.drawable.icon_download_pause);
            } else {
                SkinManager.setImageResource(this.f56559g, R.drawable.icon_download_play);
            }
        }
    }

    public void setData(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.f56561i = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        e(downloadData);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                f();
            } else {
                g();
            }
        }
    }

    public void showTitleView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f56557e.setVisibility(i2);
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
        this.f56562j = null;
        this.k = null;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadView(Context context) {
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
        this.f56562j = null;
        this.k = null;
        d(context);
    }
}
