package com.baidu.wallet.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.listview.BaseListAdapter;
import com.baidu.wallet.base.widget.listview.internal.BindLayout;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.home.beans.HomeCfgBean;
import com.baidu.wallet.home.beans.WalletHomeBeanFactory;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.storage.HomeDataCacheManager;
import com.baidu.wallet.home.ui.widget.BannerLayout;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.FinancingManageLayout;
import com.baidu.wallet.home.ui.widget.HomeInformationLayout;
import com.baidu.wallet.home.ui.widget.HomeRecommendView;
import com.baidu.wallet.home.ui.widget.LifeGridLayout;
import com.baidu.wallet.home.ui.widget.LifeSingleLineLayoutForType6;
import com.baidu.wallet.home.ui.widget.WalletHomeActionBar;
import com.baidu.wallet.home.ui.widget.credithome.CHBannerGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHBigCreditCardGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHCreditGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHFinanceEntryGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHFinanceProductGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHFinanceUserGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHLifeGridGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHMyCustomerGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHNoticeBarGroup;
import com.baidu.wallet.home.ui.widget.credithome.CHToolGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHAssetGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHBannerGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHCreditGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHCreditLongGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHCreditMiniGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHCreditPicGroup;
import com.baidu.wallet.home.ui.widget.newhome.NHFooterView;
import com.baidu.wallet.home.ui.widget.newhome.NHHorListLayout;
import com.baidu.wallet.home.ui.widget.newhome.NHLifeGridLayout;
import com.baidu.wallet.home.ui.widget.newhome.NHSeperator;
import com.baidu.wallet.home.ui.widget.newhome.NHToolGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHBigCreditCardGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHGuideGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHHeadGroup;
import com.baidu.wallet.home.ui.widget.umoneyhome.UMHNoticeBarGroup;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.passport.ThirdPartyLoginUtil;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes5.dex */
public class WalletNewHomeActivity extends BeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAGE_TYPE = "pageType";

    /* renamed from: e  reason: collision with root package name */
    public static r f25082e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f25083f = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ListView f25084a;

    /* renamed from: b  reason: collision with root package name */
    public ag f25085b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f25086c;

    /* renamed from: d  reason: collision with root package name */
    public NHFooterView f25087d;

    /* renamed from: g  reason: collision with root package name */
    public final String f25088g;

    /* renamed from: h  reason: collision with root package name */
    public String f25089h;

    /* renamed from: i  reason: collision with root package name */
    public HomeCfgResponse f25090i;
    public WalletHomeActionBar j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class a extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BannerLayout f25093a;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25093a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                BannerLayout bannerLayout = new BannerLayout(context);
                this.f25093a = bannerLayout;
                return bannerLayout;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class aa extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHSeperator f25094a;

        public aa() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25094a.setType(configData.getGroup_name());
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHSeperator nHSeperator = new NHSeperator(context);
                this.f25094a = nHSeperator;
                return nHSeperator;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class ab extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHToolGroup f25095a;

        public ab() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25095a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHToolGroup nHToolGroup = new NHToolGroup(context);
                this.f25095a = nHToolGroup;
                return nHToolGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class ac extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public UMHBigCreditCardGroup f25096a;

        public ac() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25096a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                UMHBigCreditCardGroup uMHBigCreditCardGroup = new UMHBigCreditCardGroup(context);
                this.f25096a = uMHBigCreditCardGroup;
                return uMHBigCreditCardGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class ad extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public UMHGuideGroup f25097a;

        public ad() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25097a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                UMHGuideGroup uMHGuideGroup = new UMHGuideGroup(context);
                this.f25097a = uMHGuideGroup;
                return uMHGuideGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class ae extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public UMHHeadGroup f25098a;

        public ae() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25098a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                UMHHeadGroup uMHHeadGroup = new UMHHeadGroup(context);
                this.f25098a = uMHHeadGroup;
                return uMHHeadGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class af extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public UMHNoticeBarGroup f25099a;

        public af() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25099a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                UMHNoticeBarGroup uMHNoticeBarGroup = new UMHNoticeBarGroup(context);
                this.f25099a = uMHNoticeBarGroup;
                return uMHNoticeBarGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class ag extends BaseListAdapter<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f25100a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f25101b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ag(Context context) {
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
            this.f25100a = 0;
            this.f25101b = new Handler();
        }

        public ViewGroup a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mParent : (ViewGroup) invokeV.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f25101b.post(new Runnable(this) { // from class: com.baidu.wallet.home.WalletNewHomeActivity.ag.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ag f25102a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25102a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f25102a.notifyDataSetChanged();
                        }
                    }
                });
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public int getItemTrueType(int i2) {
            InterceptResult invokeI;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                String str = getItem(i2).group_layout;
                int hashCode = str.hashCode();
                if (hashCode == 48625) {
                    if (str.equals("100")) {
                        c2 = 15;
                    }
                    c2 = 65535;
                } else if (hashCode == 49617) {
                    if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE210)) {
                        c2 = 19;
                    }
                    c2 = 65535;
                } else if (hashCode != 52500) {
                    switch (hashCode) {
                        case 49:
                            if (str.equals("1")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 50:
                            if (str.equals("2")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 51:
                            if (str.equals("3")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 52:
                            if (str.equals("4")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 53:
                            if (str.equals("5")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 54:
                            if (str.equals("6")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 55:
                            if (str.equals("7")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 56:
                            if (str.equals("8")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 57:
                            if (str.equals("9")) {
                                c2 = '\b';
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            switch (hashCode) {
                                case 49587:
                                    if (str.equals("201")) {
                                        c2 = '\t';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 49588:
                                    if (str.equals("202")) {
                                        c2 = '\n';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 49589:
                                    if (str.equals("203")) {
                                        c2 = 11;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 49590:
                                    if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE204)) {
                                        c2 = '\f';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 49591:
                                    if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE205)) {
                                        c2 = '\r';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 49592:
                                    if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206)) {
                                        c2 = 14;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 49593:
                                    if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE207)) {
                                        c2 = 16;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 49594:
                                    if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE208)) {
                                        c2 = 17;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 49595:
                                    if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE209)) {
                                        c2 = 18;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    switch (hashCode) {
                                        case 52470:
                                            if (str.equals("501")) {
                                                c2 = 20;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 52471:
                                            if (str.equals("502")) {
                                                c2 = 21;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 52472:
                                            if (str.equals("503")) {
                                                c2 = 22;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 52473:
                                            if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE504)) {
                                                c2 = 23;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 52474:
                                            if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE505)) {
                                                c2 = 24;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 52475:
                                            if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE506)) {
                                                c2 = 25;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 52476:
                                            if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE507)) {
                                                c2 = JSONLexer.EOI;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 52477:
                                            if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE508)) {
                                                c2 = 27;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 52478:
                                            if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE509)) {
                                                c2 = DecodedBitStreamParser.FS;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        default:
                                            switch (hashCode) {
                                                case 53431:
                                                    if (str.equals("601")) {
                                                        c2 = DecodedBitStreamParser.RS;
                                                        break;
                                                    }
                                                    c2 = 65535;
                                                    break;
                                                case 53432:
                                                    if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE602)) {
                                                        c2 = 31;
                                                        break;
                                                    }
                                                    c2 = 65535;
                                                    break;
                                                case 53433:
                                                    if (str.equals("603")) {
                                                        c2 = ' ';
                                                        break;
                                                    }
                                                    c2 = 65535;
                                                    break;
                                                case 53434:
                                                    if (str.equals("604")) {
                                                        c2 = '!';
                                                        break;
                                                    }
                                                    c2 = 65535;
                                                    break;
                                                case 53435:
                                                    if (str.equals("605")) {
                                                        c2 = Typography.quote;
                                                        break;
                                                    }
                                                    c2 = 65535;
                                                    break;
                                                case 53436:
                                                    if (str.equals("606")) {
                                                        c2 = '#';
                                                        break;
                                                    }
                                                    c2 = 65535;
                                                    break;
                                                default:
                                                    c2 = 65535;
                                                    break;
                                            }
                                    }
                            }
                    }
                } else {
                    if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE510)) {
                        c2 = DecodedBitStreamParser.GS;
                    }
                    c2 = 65535;
                }
                switch (c2) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 5:
                        return 5;
                    case 6:
                        return 6;
                    case 7:
                        return 7;
                    case '\b':
                        return 8;
                    case '\t':
                        return 9;
                    case '\n':
                        return 10;
                    case 11:
                        return 11;
                    case '\f':
                        return 12;
                    case '\r':
                        return 13;
                    case 14:
                        return 14;
                    case 15:
                        return 15;
                    case 16:
                        return 12;
                    case 17:
                        return 16;
                    case 18:
                        return 17;
                    case 19:
                        return 18;
                    case 20:
                        return 19;
                    case 21:
                        return 20;
                    case 22:
                        return 21;
                    case 23:
                        return 22;
                    case 24:
                        return 23;
                    case 25:
                        return 24;
                    case 26:
                        return 25;
                    case 27:
                        return 26;
                    case 28:
                        return 27;
                    case 29:
                        return 28;
                    case 30:
                        return 29;
                    case 31:
                        return 30;
                    case ' ':
                        return 31;
                    case '!':
                        return 32;
                    case '\"':
                        return 33;
                    case '#':
                        return 34;
                    default:
                        return 0;
                }
            }
            return invokeI.intValue;
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter, android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int itemTrueType = (i2 * 100) + getItemTrueType(i2);
                if (getViewTypeCount() > itemTrueType) {
                    return itemTrueType;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter, android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 10100;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f25100a++;
                super.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public void onBindViewHolder(List<Class<?>> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
                list.add(l.class);
                list.add(l.class);
                list.add(p.class);
                list.add(l.class);
                list.add(a.class);
                list.add(q.class);
                list.add(m.class);
                list.add(o.class);
                list.add(n.class);
                list.add(s.class);
                list.add(ab.class);
                list.add(t.class);
                list.add(x.class);
                list.add(y.class);
                list.add(z.class);
                list.add(aa.class);
                list.add(u.class);
                list.add(w.class);
                list.add(v.class);
                list.add(k.class);
                list.add(c.class);
                list.add(j.class);
                list.add(b.class);
                list.add(d.class);
                list.add(g.class);
                list.add(e.class);
                list.add(f.class);
                list.add(h.class);
                list.add(i.class);
                list.add(ae.class);
                list.add(af.class);
                list.add(ac.class);
                list.add(ac.class);
                list.add(b.class);
                list.add(ad.class);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public boolean useItemTrueType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class b extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHBannerGroup f25103a;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25103a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHBannerGroup cHBannerGroup = new CHBannerGroup(context);
                this.f25103a = cHBannerGroup;
                return cHBannerGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class c extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHBigCreditCardGroup f25104a;

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25104a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHBigCreditCardGroup cHBigCreditCardGroup = new CHBigCreditCardGroup(context);
                this.f25104a = cHBigCreditCardGroup;
                return cHBigCreditCardGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class d extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHCreditGroup f25105a;

        public d() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25105a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHCreditGroup cHCreditGroup = new CHCreditGroup(context);
                this.f25105a = cHCreditGroup;
                return cHCreditGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class e extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHFinanceEntryGroup f25106a;

        public e() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25106a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHFinanceEntryGroup cHFinanceEntryGroup = new CHFinanceEntryGroup(context);
                this.f25106a = cHFinanceEntryGroup;
                return cHFinanceEntryGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class f extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHFinanceProductGroup f25107a;

        public f() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25107a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHFinanceProductGroup cHFinanceProductGroup = new CHFinanceProductGroup(context);
                this.f25107a = cHFinanceProductGroup;
                return cHFinanceProductGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class g extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHFinanceUserGroup f25108a;

        public g() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25108a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHFinanceUserGroup cHFinanceUserGroup = new CHFinanceUserGroup(context);
                this.f25108a = cHFinanceUserGroup;
                return cHFinanceUserGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class h extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHLifeGridGroup f25109a;

        public h() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25109a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHLifeGridGroup cHLifeGridGroup = new CHLifeGridGroup(context);
                this.f25109a = cHLifeGridGroup;
                return cHLifeGridGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class i extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHMyCustomerGroup f25110a;

        public i() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25110a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHMyCustomerGroup cHMyCustomerGroup = new CHMyCustomerGroup(context);
                this.f25110a = cHMyCustomerGroup;
                return cHMyCustomerGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class j extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHNoticeBarGroup f25111a;

        public j() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25111a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHNoticeBarGroup cHNoticeBarGroup = new CHNoticeBarGroup(context);
                this.f25111a = cHNoticeBarGroup;
                return cHNoticeBarGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class k extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CHToolGroup f25112a;

        public k() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25112a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                CHToolGroup cHToolGroup = new CHToolGroup(context);
                this.f25112a = cHToolGroup;
                return cHToolGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class l extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25113a;

        public l() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                View view = new View(context);
                this.f25113a = view;
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class m extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FinancingManageLayout f25114a;

        public m() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25114a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                FinancingManageLayout financingManageLayout = new FinancingManageLayout(context);
                this.f25114a = financingManageLayout;
                return financingManageLayout;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class n extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HomeInformationLayout f25115a;

        public n() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25115a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                HomeInformationLayout homeInformationLayout = new HomeInformationLayout(context);
                this.f25115a = homeInformationLayout;
                return homeInformationLayout;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class o extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HomeRecommendView f25116a;

        public o() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25116a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                HomeRecommendView homeRecommendView = new HomeRecommendView(context);
                this.f25116a = homeRecommendView;
                return homeRecommendView;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class p extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LifeGridLayout f25117a;

        public p() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25117a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                LifeGridLayout lifeGridLayout = new LifeGridLayout(context);
                this.f25117a = lifeGridLayout;
                return lifeGridLayout;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class q extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LifeSingleLineLayoutForType6 f25118a;

        public q() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25118a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                LifeSingleLineLayoutForType6 lifeSingleLineLayoutForType6 = new LifeSingleLineLayoutForType6(context);
                this.f25118a = lifeSingleLineLayoutForType6;
                return lifeSingleLineLayoutForType6;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class r implements com.baidu.wallet.home.ui.widget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ag f25119a;

        /* renamed from: b  reason: collision with root package name */
        public HomeCfgResponse f25120b;

        /* renamed from: c  reason: collision with root package name */
        public Context f25121c;

        /* renamed from: d  reason: collision with root package name */
        public WeakReference<Activity> f25122d;

        /* renamed from: e  reason: collision with root package name */
        public String f25123e;

        public r(Activity activity, ag agVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, agVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25123e = str;
            this.f25121c = activity.getApplicationContext();
            this.f25122d = new WeakReference<>(activity);
            this.f25119a = agVar;
        }

        public void a(HomeCfgResponse homeCfgResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, homeCfgResponse) == null) {
                this.f25120b = homeCfgResponse;
                com.baidu.wallet.home.a.a().a(this.f25120b.abtype);
            }
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public String getAndroidPrefix() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f25120b.android_prefix) ? "" : this.f25120b.android_prefix : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public String getPageType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25123e : (String) invokeV.objValue;
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public boolean isLoginData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25120b.isLogin() : invokeV.booleanValue;
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public void jump(String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
                WeakReference<Activity> weakReference = this.f25122d;
                com.baidu.wallet.home.a.a().a((weakReference == null || weakReference.get() == null) ? this.f25121c : this.f25122d.get(), str, str2, str3, z, this.f25123e);
            }
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public void login() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                WalletLoginHelper.getInstance().setIntervalDuration(0L);
                WalletLoginHelper.getInstance().onlyLogin(new LoginBackListenerProxy(this.f25121c, new ILoginBackListener(this) { // from class: com.baidu.wallet.home.WalletNewHomeActivity.r.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ r f25124a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25124a = this;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) && i2 == 603) {
                            this.f25124a.login();
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        }
                    }
                }));
            }
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public void onEyeMaskBtnClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                boolean z = !com.baidu.wallet.home.storage.a.a(this.f25121c);
                com.baidu.wallet.home.storage.a.a(this.f25121c, z);
                String str = com.baidu.wallet.home.a.a.f25137a;
                String[] strArr = new String[1];
                strArr[0] = z ? "true" : "false";
                DXMSdkSAUtils.onEventWithValues(str, Arrays.asList(strArr));
                PayStatisticsUtil.onEventWithValue(com.baidu.wallet.home.a.a.f25137a, z ? "true" : "false");
                ag agVar = this.f25119a;
                if (agVar != null) {
                    ListView listView = (ListView) agVar.a();
                    for (int i2 = 0; i2 < listView.getChildCount(); i2++) {
                        if (listView.getChildAt(i2) instanceof BaseItemLayout) {
                            ((BaseItemLayout) listView.getChildAt(i2)).onEyeMaskChanged();
                        }
                    }
                    this.f25119a.b();
                }
            }
        }

        @Override // com.baidu.wallet.home.ui.widget.b
        public void onPointShowChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class s extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHAssetGroup f25125a;

        public s() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25125a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHAssetGroup nHAssetGroup = new NHAssetGroup(context);
                this.f25125a = nHAssetGroup;
                return nHAssetGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class t extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHBannerGroup f25126a;

        public t() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25126a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHBannerGroup nHBannerGroup = new NHBannerGroup(context);
                this.f25126a = nHBannerGroup;
                return nHBannerGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class u extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHCreditLongGroup f25127a;

        public u() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25127a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHCreditLongGroup nHCreditLongGroup = new NHCreditLongGroup(context);
                this.f25127a = nHCreditLongGroup;
                return nHCreditLongGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class v extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHCreditMiniGroup f25128a;

        public v() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25128a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHCreditMiniGroup nHCreditMiniGroup = new NHCreditMiniGroup(context);
                this.f25128a = nHCreditMiniGroup;
                return nHCreditMiniGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class w extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHCreditPicGroup f25129a;

        public w() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25129a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHCreditPicGroup nHCreditPicGroup = new NHCreditPicGroup(context);
                this.f25129a = nHCreditPicGroup;
                return nHCreditPicGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class x extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHCreditGroup f25130a;

        public x() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25130a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHCreditGroup nHCreditGroup = new NHCreditGroup(context);
                this.f25130a = nHCreditGroup;
                return nHCreditGroup;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class y extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHHorListLayout f25131a;

        public y() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25131a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHHorListLayout nHHorListLayout = new NHHorListLayout(context);
                this.f25131a = nHHorListLayout;
                return nHHorListLayout;
            }
            return (View) invokeL.objValue;
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class z extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.ConfigData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NHLifeGridLayout f25132a;

        public z() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.ConfigData configData, int i2, Context context, BaseListAdapter<HomeCfgResponse.ConfigData> baseListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, configData, i2, context, baseListAdapter) == null) {
                this.f25132a.setConfigData(configData, WalletNewHomeActivity.f25082e);
            }
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                NHLifeGridLayout nHLifeGridLayout = new NHLifeGridLayout(context);
                this.f25132a = nHLifeGridLayout;
                return nHLifeGridLayout;
            }
            return (View) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1220390130, "Lcom/baidu/wallet/home/WalletNewHomeActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1220390130, "Lcom/baidu/wallet/home/WalletNewHomeActivity;");
        }
    }

    public WalletNewHomeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25088g = toString() + hashCode();
        this.f25089h = HomeCfgBean.PAGE_HOME;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = true;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            initHomeActionBar("dxm_finance_brand");
            this.j = (WalletHomeActionBar) findViewById(ResUtils.id(this.mAct, "bdactionbar"));
            if (HomeCfgBean.PAGE_CREDIT.equals(this.f25089h)) {
                this.j.setRightImgZone1Visibility(4);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.m = false;
            HomeCfgResponse responseFromCache = HomeDataCacheManager.getInstance().getResponseFromCache(this.mAct, this.f25089h);
            if (responseFromCache != null && responseFromCache.doCheckValidity()) {
                this.f25090i = responseFromCache;
                this.m = true;
                c();
                d();
                return;
            }
            d();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (this.m) {
                this.m = false;
                if (this.l) {
                    this.l = false;
                    return;
                }
            }
            HomeCfgResponse homeCfgResponse = this.f25090i;
            if (homeCfgResponse == null || !homeCfgResponse.doCheckValidity()) {
                this.f25090i = HomeDataCacheManager.getInstance().getResponseFromAsset(this.mAct, this.f25089h);
            }
            HomeCfgResponse homeCfgResponse2 = this.f25090i;
            if (homeCfgResponse2 == null || !homeCfgResponse2.doCheckValidity()) {
                return;
            }
            r rVar = f25082e;
            if (rVar != null) {
                rVar.a(this.f25090i);
            }
            this.f25086c.setBackgroundColor(ResUtils.getColor(this, "5".equals(this.f25090i.version) ? "wallet_home_nh_whiteColor" : "wallet_extend_home_nh_separate_bright"));
            WalletHomeActionBar walletHomeActionBar = this.j;
            BeanActivity beanActivity = this.mAct;
            HomeCfgResponse homeCfgResponse3 = this.f25090i;
            walletHomeActionBar.toRefreshTitleBar(beanActivity, homeCfgResponse3.android_prefix, homeCfgResponse3.layout_title, this.f25089h);
            HomeCfgResponse.ConfigData[] a2 = com.baidu.wallet.home.ui.widget.newhome.a.a(this.f25090i);
            this.f25085b.initList(Arrays.asList(a2));
            a(this.f25090i, a2);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.l = false;
            HomeCfgBean homeCfgBean = (HomeCfgBean) WalletHomeBeanFactory.getInstance().getBean((Context) this.mAct, WalletHomeBeanFactory.BEAN_ID_HOME_CFG, this.f25088g);
            homeCfgBean.setAbtypeHomePage(true);
            HomeCfgResponse homeCfgResponse = this.f25090i;
            if (homeCfgResponse != null) {
                HomeCfgResponse.AllConfig allConfig = homeCfgResponse.layout_content;
                if (allConfig != null && !TextUtils.isEmpty(allConfig.fingerprint)) {
                    homeCfgBean.setAllFingerPrint(this.f25090i.layout_content.fingerprint);
                } else {
                    homeCfgBean.setAllFingerPrint(null);
                }
                HomeCfgResponse.TitleConfig titleConfig = this.f25090i.layout_title;
                if (titleConfig != null && !TextUtils.isEmpty(titleConfig.fingerprint)) {
                    homeCfgBean.setTitleFingerPrint(this.f25090i.layout_title.fingerprint);
                } else {
                    homeCfgBean.setTitleFingerPrint(null);
                }
                HomeCfgResponse.FooterConfig footerConfig = this.f25090i.layout_footer;
                if (footerConfig != null && !TextUtils.isEmpty(footerConfig.fingerprint)) {
                    homeCfgBean.setFooterFingerPrint(this.f25090i.layout_footer.fingerprint);
                } else {
                    homeCfgBean.setFooterFingerPrint(null);
                }
                if (this.f25090i.doCheckValidity() && !TextUtils.isEmpty(this.f25090i.changedSign)) {
                    homeCfgBean.setChangeSign(this.f25090i.changedSign);
                } else {
                    homeCfgBean.setChangeSign(null);
                }
            }
            homeCfgBean.setPageId(TextUtils.isEmpty(this.f25089h) ? HomeCfgBean.PAGE_HOME : this.f25089h);
            homeCfgBean.setResponseCallback(this);
            homeCfgBean.execBean();
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            if (i3 == -8) {
                if (!this.k) {
                    BeanActivity beanActivity = this.mAct;
                    GlobalUtils.toast(beanActivity, ResUtils.getString(beanActivity, "ebpay_no_network"));
                }
            } else if (i3 == 5003) {
                if (!this.k) {
                    if (WalletLoginHelper.getInstance().isPassLogin()) {
                        WalletLoginHelper.getInstance().handlerWalletError(5003);
                        AccountManager.getInstance(getActivity()).logout();
                        WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(this, new ILoginBackListener(this) { // from class: com.baidu.wallet.home.WalletNewHomeActivity.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ WalletNewHomeActivity f25091a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f25091a = this;
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onFail(int i4, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                                }
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onSuccess(int i4, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) {
                                }
                            }
                        }));
                    }
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_please_login"));
                }
            } else if (!ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.mAct.getActivity(), i3, str, new WalletApiExtListener.ThirdPartyLoginListener(this) { // from class: com.baidu.wallet.home.WalletNewHomeActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletNewHomeActivity f25092a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25092a = this;
                }

                @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                public void onCallFail(int i4, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                        this.f25092a.mAct.finish();
                    }
                }

                @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                public void onCallSuccess(int i4, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) {
                    }
                }
            })) {
                if (!TextUtils.isEmpty(str)) {
                    if (!this.k) {
                        GlobalUtils.toast(this.mAct, str);
                    }
                } else if (!this.k) {
                    super.handleFailure(i2, i3, str);
                }
            }
            this.k = true;
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
            this.k = true;
            if (obj == null || !(obj instanceof HomeCfgResponse)) {
                return;
            }
            HomeCfgResponse homeCfgResponse = (HomeCfgResponse) obj;
            if (homeCfgResponse.doCheckValidity()) {
                this.f25090i = homeCfgResponse;
                if (!homeCfgResponse.isLogin()) {
                    AccountManager.getInstance(getActivity()).logout();
                }
                this.f25090i.doStoreResponse(this.mAct, this.f25089h);
                c();
                this.l = true;
            }
        }
    }

    public void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25086c = (LinearLayout) findViewById(ResUtils.id(this, "homerootview"));
            this.f25084a = (ListView) findViewById(ResUtils.id(this, "listview"));
            ag agVar = new ag(this);
            this.f25085b = agVar;
            this.f25084a.setAdapter((ListAdapter) agVar);
            this.f25084a.setBackgroundColor(ResUtils.getColor(this, "bd_wallet_white"));
            f25083f = this.f25088g;
            f25082e = new r(getActivity(), this.f25085b, this.f25089h);
            a();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: com.baidu.wallet.home.ui.widget.newhome.NHSeperator */
    /* JADX WARN: Multi-variable type inference failed */
    public int measureHomeLayout(Context context, HomeCfgResponse.ConfigData[] configDataArr, com.baidu.wallet.home.ui.widget.b bVar) {
        InterceptResult invokeLLL;
        BaseItemLayout baseItemLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, configDataArr, bVar)) == null) {
            int displayHeight = DisplayUtils.getDisplayHeight(context) - DisplayUtils.dip2px(context, ((BeanConstants.CHANNEL_ID_KUANG.equals(BeanConstants.CHANNEL_ID) ? 38.0f : 50.0f) + 0.0f) + 20.0f);
            int i2 = 0;
            for (int i3 = 0; i3 < configDataArr.length; i3++) {
                if (configDataArr[i3].getGroup_layout().equals("100")) {
                    NHSeperator nHSeperator = new NHSeperator(context);
                    nHSeperator.setType(configDataArr[i3].getGroup_name());
                    baseItemLayout = nHSeperator;
                } else {
                    BaseItemLayout a2 = com.baidu.wallet.home.ui.widget.a.a().a(context, configDataArr[i3], null);
                    baseItemLayout = a2;
                    if (a2 != null) {
                        a2.setConfigData(configDataArr[i3], bVar);
                        baseItemLayout = a2;
                    }
                }
                if (baseItemLayout != null) {
                    com.baidu.wallet.home.ui.a.a(baseItemLayout);
                    i2 += baseItemLayout.getMeasuredHeight();
                }
                if (i2 >= displayHeight) {
                    return 0;
                }
            }
            return displayHeight - i2;
        }
        return invokeLLL.intValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.l = false;
            this.m = false;
            this.n = true;
            String string = getIntent().getExtras().getString("pageType");
            if (!TextUtils.isEmpty(string)) {
                this.f25089h = string;
            }
            getActivity().getWindow().setSoftInputMode(3);
            setContentView(ResUtils.layout(this.mAct, "wallet_home_main_new"));
            initViews();
            b();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(this.f25088g);
            if (f25083f.equals(this.f25088g)) {
                f25082e = null;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            super.onNewIntent(intent);
            String string = intent.getExtras().getString("pageType");
            if (!TextUtils.isEmpty(string)) {
                this.f25089h = string;
            }
            this.l = false;
            this.m = false;
            this.n = true;
            b();
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (this.n) {
                this.n = false;
                return;
            }
            HomeDataCacheManager.getInstance().synPPkey(this.mAct);
            d();
        }
    }

    private void a(HomeCfgResponse homeCfgResponse, HomeCfgResponse.ConfigData[] configDataArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, homeCfgResponse, configDataArr) == null) {
            if (homeCfgResponse.layout_footer != null && this.f25087d == null) {
                NHFooterView nHFooterView = new NHFooterView(this);
                this.f25087d = nHFooterView;
                this.f25084a.addFooterView(nHFooterView);
            }
            if (this.f25087d != null) {
                r rVar = f25082e;
                this.f25087d.setData(homeCfgResponse, f25082e, rVar == null ? 0 : measureHomeLayout(this, configDataArr, rVar));
            }
        }
    }
}
