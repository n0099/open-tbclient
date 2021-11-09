package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.StatHelper;
/* loaded from: classes10.dex */
public class IdentifyCodeGetFailDialog extends PromptDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public VerifyCodeType f60453a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class VerifyCodeType {
        public static final /* synthetic */ VerifyCodeType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VerifyCodeType SMS;
        public static final VerifyCodeType VOICE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1314020875, "Lcom/baidu/wallet/paysdk/ui/widget/IdentifyCodeGetFailDialog$VerifyCodeType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1314020875, "Lcom/baidu/wallet/paysdk/ui/widget/IdentifyCodeGetFailDialog$VerifyCodeType;");
                    return;
                }
            }
            SMS = new VerifyCodeType("SMS", 0);
            VerifyCodeType verifyCodeType = new VerifyCodeType("VOICE", 1);
            VOICE = verifyCodeType;
            $VALUES = new VerifyCodeType[]{SMS, verifyCodeType};
        }

        public VerifyCodeType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static VerifyCodeType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VerifyCodeType) Enum.valueOf(VerifyCodeType.class, str) : (VerifyCodeType) invokeL.objValue;
        }

        public static VerifyCodeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VerifyCodeType[]) $VALUES.clone() : (VerifyCodeType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IdentifyCodeGetFailDialog(Context context) {
        this(context, VerifyCodeType.SMS);
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
                this((Context) objArr2[0], (VerifyCodeType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f60453a == VerifyCodeType.VOICE ? "ebpay_get_voice_code_error_title" : "ebpay_get_sms_error_dialog_title" : (String) invokeV.objValue;
    }

    private SpannableStringBuilder c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            String string = ResUtils.getString(this.mContext, "ebpay_operation_tip1");
            String string2 = ResUtils.getString(this.mContext, "ebpay_operation_tip2");
            String string3 = ResUtils.getString(this.mContext, "ebpay_operation_tip3");
            String string4 = ResUtils.getString(this.mContext, "ebpay_operation_tip4");
            String string5 = ResUtils.getString(this.mContext, "ebpay_operation_tip5");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.append((CharSequence) string2);
            spannableStringBuilder.append((CharSequence) string3);
            spannableStringBuilder.append((CharSequence) string4);
            spannableStringBuilder.append((CharSequence) string5);
            spannableStringBuilder.append((CharSequence) BdWalletUtils.getKefuPhoneNum(this.mContext));
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    private SpannableStringBuilder d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            String string = ResUtils.getString(this.mContext, "ebpay_operation_tip1");
            String string2 = ResUtils.getString(this.mContext, "ebpay_operation_voice_verify_tip2");
            String string3 = ResUtils.getString(this.mContext, "ebpay_operation_voice_verify_tip3");
            String string4 = ResUtils.getString(this.mContext, "ebpay_operation_voice_verify_tip4");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.append((CharSequence) string2);
            spannableStringBuilder.append((CharSequence) string3);
            spannableStringBuilder.append((CharSequence) string4);
            spannableStringBuilder.append((CharSequence) BdWalletUtils.getKefuPhoneNum(this.mContext));
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.WalletDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            setTitleText(ResUtils.getString(this.mContext, b()));
            showCloseBtn(false);
            setMessage(a());
            setNegativeBtn(ResUtils.getString(this.mContext, "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IdentifyCodeGetFailDialog f60454a;

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
                    this.f60454a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.SMS_INFO_CONFIRM);
                        this.f60454a.dismiss();
                    }
                }
            });
            setPositiveBtn(ResUtils.getString(this.mContext, "ebpay_contact_kefu"), new View.OnClickListener(this, BdWalletUtils.getKefuPhoneNum(this.mContext)) { // from class: com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f60455a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IdentifyCodeGetFailDialog f60456b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60456b = this;
                    this.f60455a = r7;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.SMS_INFO_KEFU);
                        try {
                            this.f60456b.mContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.f60455a)));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentifyCodeGetFailDialog(Context context, VerifyCodeType verifyCodeType) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, verifyCodeType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60453a = verifyCodeType;
    }

    private SpannableStringBuilder a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.f60453a == VerifyCodeType.VOICE ? d() : c();
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }
}
