package com.baidu.tieba.personPolymeric.header;

import android.view.View;
import c.a.e.e.l.c;
import c.a.e.e.l.d;
import c.a.e.e.p.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes7.dex */
public class PersonHeaderBackgroundController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56044a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f56045b;

    /* renamed from: c  reason: collision with root package name */
    public View f56046c;

    /* renamed from: d  reason: collision with root package name */
    public UserData f56047d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56048e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f56049f;

    /* loaded from: classes7.dex */
    public class a extends c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonHeaderBackgroundController f56050a;

        public a(PersonHeaderBackgroundController personHeaderBackgroundController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personHeaderBackgroundController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56050a = personHeaderBackgroundController;
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // c.a.e.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                super.onLoaded((a) aVar, str, i2);
                if (aVar != null) {
                    aVar.h(this.f56050a.f56045b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonHeaderBackgroundController f56051e;

        public b(PersonHeaderBackgroundController personHeaderBackgroundController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personHeaderBackgroundController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56051e = personHeaderBackgroundController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f56051e.f56048e) {
                if (this.f56051e.f56047d == null || !this.f56051e.f56047d.isBaijiahaoUser()) {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                    String userId = this.f56051e.f56047d.getUserId();
                    String bg_pic = this.f56051e.f56047d.getBg_pic();
                    try {
                        i2 = c.a.e.e.m.b.e((String) this.f56051e.f(bg_pic).get("props_id"), -1);
                    } catch (URISyntaxException unused) {
                        i2 = -1;
                    }
                    if (i2 != -1 && !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                        int i3 = 0;
                        if (currentAccountInfo != null && !StringUtils.isNull(bg_pic) && !StringUtils.isNull(currentAccountInfo.getPersonalBgUrl()) && bg_pic.equalsIgnoreCase(currentAccountInfo.getPersonalBgUrl())) {
                            i3 = 1;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackgroundPreviewActivityConfig(this.f56051e.f56045b.getContext(), i2, i3)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.f56051e.f56045b.getContext())));
                }
            }
        }
    }

    public PersonHeaderBackgroundController(TbPageContext tbPageContext, TbImageView tbImageView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbImageView, view, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56049f = new b(this);
        this.f56044a = tbPageContext;
        this.f56045b = tbImageView;
        this.f56048e = z;
        tbImageView.setDefaultBgResource(R.drawable.bg_pic_mine);
        this.f56046c = view;
        view.setOnClickListener(this.f56049f);
    }

    public void e(UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, userData) == null) || userData == null) {
            return;
        }
        this.f56047d = userData;
        String bg_pic = userData.getBg_pic();
        if (k.isEmpty(bg_pic)) {
            return;
        }
        d.h().k(bg_pic, 10, new a(this), 0, 0, this.f56044a.getUniqueId(), new Object[0]);
    }

    public final Map<String, String> f(String str) throws URISyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new HashMap<String, String>(this, str) { // from class: com.baidu.tieba.personPolymeric.header.PersonHeaderBackgroundController.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonHeaderBackgroundController this$0;
            public final /* synthetic */ String val$url;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$url = str;
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(this.val$url), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        } : (Map) invokeL.objValue;
    }
}
