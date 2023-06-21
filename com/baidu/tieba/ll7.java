package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton;
import com.baidu.tieba.cm7;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoAlbumLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoBriefLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoDownloadLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoTagLayout;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetMsg;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ApkDetail;
import tbclient.GameCodeList;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class ll7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public CardItemInfoDownloadLayout b;
    public CardItemInfoAlbumLayout c;
    public CardItemInfoTagLayout d;
    public CardItemInfoBriefLayout e;
    public BdTypeRecyclerView f;
    public kl7 g;
    public nl7 h;
    public View i;
    public ItemCardDownloadButton j;
    public TextView k;
    public View l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public View.OnClickListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public HttpMessageListener s;

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ll7 ll7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                eo6.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ll7 ll7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.a.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    ua5 ua5Var = new ua5(8);
                    ua5Var.q(objTypeByDownloadMode);
                    int intValue = this.a.j.getCurrentItem().buttonLinkType.intValue();
                    if (this.a.j.getCurrentItem().apkDetail != null) {
                        i = this.a.j.getCurrentItem().apkDetail.pkg_source.intValue();
                    } else {
                        i = 0;
                    }
                    ua5Var.p(va5.a(intValue, i));
                    ua5Var.n(str);
                    if (this.a.h != null && this.a.h.a != null) {
                        ua5Var.l(this.a.h.a.category1);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ua5Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        public c(ll7 ll7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, view2));
                Object tag = view2.getTag(R.id.item_data);
                if (tag instanceof ta5) {
                    ItemData a = ((ta5) tag).a();
                    if (ItemCardHelper.a.equals(a.buttonName) || ItemCardHelper.b.equals(a.buttonName) || ItemCardHelper.f.equals(a.buttonName)) {
                        ua5 ua5Var = new ua5(8);
                        ua5Var.q(va5.b(a.buttonName));
                        int intValue = a.buttonLinkType.intValue();
                        ApkDetail apkDetail = a.apkDetail;
                        if (apkDetail != null) {
                            i = apkDetail.pkg_source.intValue();
                        } else {
                            i = 0;
                        }
                        ua5Var.p(va5.a(intValue, i));
                        if (this.a.h != null && this.a.h.a != null) {
                            ua5Var.l(this.a.h.a.category1);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ua5Var));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        public d(ll7 ll7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int objTypeByDownloadMode = this.a.j.getObjTypeByDownloadMode();
                int intValue = this.a.j.getCurrentItem().buttonLinkType.intValue();
                if (this.a.j.getCurrentItem().apkDetail != null) {
                    i2 = this.a.j.getCurrentItem().apkDetail.pkg_source.intValue();
                } else {
                    i2 = 0;
                }
                int a = va5.a(intValue, i2);
                if (objTypeByDownloadMode > 0 && a != 4) {
                    ua5 ua5Var = new ua5(8);
                    ua5Var.q(objTypeByDownloadMode);
                    ua5Var.p(a);
                    if (this.a.h != null && this.a.h.a != null) {
                        ua5Var.l(this.a.h.a.category1);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ua5Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ll7 ll7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            PlayVoiceBnt playVoiceBnt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (view2 = viewHolder.itemView) != null && (playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice)) != null) {
                playVoiceBnt.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ll7 ll7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.m = (String) customResponsedMessage.getData();
                ItemCardHelper.z(this.a.k, this.a.m);
                this.a.j.setCustomColorBtn(gy9.f(this.a.m));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ll7 ll7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zp7)) {
                zp7 zp7Var = (zp7) customResponsedMessage.getData();
                if (zp7Var.b == this.a.a.a) {
                    int i = zp7Var.c;
                    if (i != 0 && i != 2) {
                        if (i == 1) {
                            zp7Var.a = null;
                            return;
                        }
                        return;
                    }
                    zp7Var.a = this.a.i;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ll7 ll7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003516 || this.a.h.c.get(0).getType() != fm7.c) {
                return;
            }
            int error = httpResponsedMessage.getError();
            GameCodeGetResponseMsg gameCodeGetResponseMsg = (GameCodeGetResponseMsg) httpResponsedMessage;
            if (httpResponsedMessage.getStatusCode() == 200 && error == 0 && gameCodeGetResponseMsg.errCode == 0) {
                this.a.s(true, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f08c9));
                km7 km7Var = new km7(((GameCodeGetMsg) httpResponsedMessage.getOrginalMessage()).getPosition(), gameCodeGetResponseMsg.getCodeValue());
                this.a.t(km7Var);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921640, km7Var));
                return;
            }
            this.a.s(false, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f08c8));
        }
    }

    public ll7(FrsItemTabFragment frsItemTabFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.n = new a(this);
        this.o = new b(this, 2921609);
        this.p = new c(this);
        this.q = new f(this, 2921591);
        this.r = new g(this, 2921590);
        this.s = new h(this, CmdConfigHttp.CMD_GET_GAME_CODE);
        if (frsItemTabFragment != null && view2 != null) {
            this.a = frsItemTabFragment;
            this.r.setSelfListener(true);
            frsItemTabFragment.getBaseFragmentActivity().registerListener(this.r);
            frsItemTabFragment.registerListener(this.q);
            frsItemTabFragment.registerListener(this.s);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090c4c);
            ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view2.findViewById(R.id.obfuscated_res_0x7f090c4a);
            this.j = itemCardDownloadButton;
            itemCardDownloadButton.setShadow(R.array.S_O_X003);
            this.j.A();
            this.j.setClickCallback(new d(this));
            this.o.setSelfListener(true);
            this.o.setTag(this.j.getTag());
            MessageManager.getInstance().registerListener(this.o);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c4b);
            this.k = textView;
            textView.setOnClickListener(this.p);
            p75.d(this.k).w(R.array.S_O_X003);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090cc9);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.addOnScrollListener(this.n);
            this.f.setRecyclerListener(new e(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f.getPaddingBottom());
            this.b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
            this.c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
            this.d = new CardItemInfoTagLayout(frsItemTabFragment.getContext());
            this.e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
            this.g = new kl7(frsItemTabFragment, this.f);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        kl7 kl7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) && (kl7Var = this.g) != null) {
            kl7Var.h(bdUniqueId);
        }
    }

    public void o(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (bdTypeRecyclerView = this.f) != null) {
            bdTypeRecyclerView.setSelection(i);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.m = str;
        }
    }

    public void q(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (bdTypeRecyclerView = this.f) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            bdTypeRecyclerView.setVisibility(i);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.removeHeaderView(this.b);
            this.f.removeHeaderView(this.c);
            this.f.removeHeaderView(this.d);
            this.f.removeHeaderView(this.e);
            nl7 nl7Var = this.h;
            if (nl7Var == null) {
                return;
            }
            if (nl7Var.a != null) {
                this.f.addHeaderView(this.b);
                this.b.setData(this.h.a);
            }
            if (!ListUtils.isEmpty(this.h.b)) {
                this.f.addHeaderView(this.c);
                this.c.setData(this.h.b);
            }
            ItemInfo itemInfo = this.h.a;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f.addHeaderView(this.d);
                this.d.setData(this.h.a);
            }
            if (this.h.a != null) {
                this.f.addHeaderView(this.e);
                this.e.setData(this.h.a);
            }
        }
    }

    public void i(boolean z) {
        int paddingBottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view2 = this.i;
            int paddingLeft = view2.getPaddingLeft();
            int paddingTop = this.i.getPaddingTop();
            int paddingRight = this.i.getPaddingRight();
            if (z) {
                paddingBottom = UtilHelper.getDimenPixelSize(R.dimen.tbds200);
            } else {
                paddingBottom = this.i.getPaddingBottom();
            }
            view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void l(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            zp7 zp7Var = new zp7();
            if (z) {
                i = this.a.a;
            } else {
                i = 0;
            }
            zp7Var.b = i;
            zp7Var.c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, zp7Var);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            kl7 kl7Var = this.g;
            if (kl7Var != null) {
                kl7Var.d();
            }
            this.b.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.c.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.d.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.e.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.j.v();
            p75 d2 = p75.d(this.k);
            if (!ItemCardHelper.d.contentEquals(this.k.getText()) && !ItemCardHelper.f.contentEquals(this.k.getText())) {
                this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0101));
                d2.o(R.string.J_X01);
                d2.l(R.color.transparent);
                d2.h(gy9.f(this.m));
            } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                p75.d(this.k).x(R.color.CAM_X0103);
                d2.m(R.dimen.tbds1);
                d2.l(R.color.CAM_X0209);
                d2.o(R.string.J_X01);
                d2.f(R.color.CAM_X0209);
            } else {
                this.k.setTextColor(gy9.a(gy9.f(this.m), n75.b(R.string.A_X01)));
                d2.m(R.dimen.tbds1);
                d2.v(gy9.a(gy9.f(this.m), n75.b(R.string.A_X07)));
                d2.o(R.string.J_X01);
                d2.f(R.color.CAM_X0208);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            kl7 kl7Var = this.g;
            if (kl7Var != null) {
                kl7Var.f();
            }
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    public void m(nl7 nl7Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, nl7Var) != null) || nl7Var == null) {
            return;
        }
        this.h = nl7Var;
        h();
        if (nl7Var.d) {
            cm7.b bVar = new cm7.b();
            bVar.e(this.m);
            ItemInfo itemInfo = nl7Var.a;
            if (itemInfo != null) {
                j = itemInfo.id.intValue();
            } else {
                j = 0;
            }
            bVar.d(j);
            this.h.c.add(0, bVar.c());
        }
        if (nl7Var.a != null) {
            ItemData itemData = new ItemData();
            itemData.parseProto(nl7Var.a);
            ta5 ta5Var = new ta5(itemData, 0, "");
            if (ItemCardHelper.x(itemData) && ItemCardHelper.o(itemData)) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setCustomColorBtn(gy9.f(this.m));
                this.j.B();
                this.j.setData(itemData, -1, this.a.e, 0);
                int objTypeByDownloadMode = this.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    ua5 ua5Var = new ua5(7);
                    ua5Var.q(objTypeByDownloadMode);
                    ua5Var.l(nl7Var.a.category1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ua5Var));
                }
                r();
            } else {
                ItemCardHelper.m(this.k, ta5Var, this.m);
                if (!ItemCardHelper.e.equals(itemData.buttonName)) {
                    p75 d2 = p75.d(this.k);
                    if (!ItemCardHelper.d.equals(itemData.buttonName) && !ItemCardHelper.f.equals(itemData.buttonName)) {
                        this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0101));
                        d2.o(R.string.J_X01);
                        d2.l(R.color.transparent);
                        d2.h(gy9.f(this.m));
                    } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                        p75.d(this.k).x(R.color.CAM_X0103);
                        d2.m(R.dimen.tbds1);
                        d2.l(R.color.CAM_X0209);
                        d2.o(R.string.J_X01);
                        d2.f(R.color.CAM_X0209);
                    } else {
                        this.k.setTextColor(gy9.a(gy9.f(this.m), n75.b(R.string.A_X01)));
                        d2.m(R.dimen.tbds1);
                        d2.v(gy9.a(gy9.f(this.m), n75.b(R.string.A_X07)));
                        d2.o(R.string.J_X01);
                        d2.f(R.color.CAM_X0208);
                    }
                    this.i.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(itemData.buttonName);
                    if (ItemCardHelper.f.equals(itemData.buttonName)) {
                        this.k.setEnabled(false);
                    }
                    r();
                    if (ItemCardHelper.a.equals(itemData.buttonName) || ItemCardHelper.b.equals(itemData.buttonName) || ItemCardHelper.f.equals(itemData.buttonName)) {
                        ua5 ua5Var2 = new ua5(7);
                        ua5Var2.q(va5.b(itemData.buttonName));
                        ua5Var2.l(nl7Var.a.category1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, ua5Var2));
                    }
                }
            }
        }
        this.g.g(nl7Var.c);
        this.g.d();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.l == null) {
                this.l = new View(this.a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds200)));
            }
            this.f.setFooterView(this.l);
        }
    }

    public void s(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) ((Activity) this.a.getContext()).findViewById(16908290));
        }
    }

    public void t(km7 km7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, km7Var) == null) {
            ((fm7) this.h.c.get(0)).a--;
            List<GameCodeList> list = ((fm7) this.h.c.get(0)).b;
            GameCodeList gameCodeList = list.get(km7Var.a);
            list.remove(km7Var.a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = km7Var.b;
            builder.type = gameCodeList.type;
            builder.label = gameCodeList.label;
            builder.begin_time = gameCodeList.begin_time;
            builder.end_time = gameCodeList.end_time;
            builder.item_id = gameCodeList.item_id;
            builder.list_id = gameCodeList.list_id;
            GameCodeList build = builder.build(false);
            int i = km7Var.a;
            while (i < list.size() && list.get(i).claimed_status.intValue() == 1) {
                i++;
            }
            while (i < list.size() && list.get(i).end_time.intValue() < build.end_time.intValue() && list.get(i).claimed_status.intValue() == 2) {
                i++;
            }
            list.add(i, build);
            this.g.e();
        }
    }
}
