package com.baidu.tieba.immessagecenter.msgtab.repository;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.bk8;
import com.baidu.tieba.immessagecenter.arch.base.BaseRepository;
import com.baidu.tieba.immessagecenter.msgtab.data.CacheDataType;
import com.baidu.tieba.immessagecenter.msgtab.data.ForumListData;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J*\u0010 \u001a\u00020\u001e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u001e0\"J\u001c\u0010#\u001a\u00020\u001e2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u001e0\"J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0006H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/repository/MsgCenterRepository;", "Lcom/baidu/tieba/immessagecenter/arch/base/BaseRepository;", "()V", "_cache", "", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/ForumListData;", "_spInstance", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "get_spInstance", "()Landroid/content/SharedPreferences;", "_spInstance$delegate", "Lkotlin/Lazy;", "mRequestCallback", "Lcom/baidu/tieba/immessagecenter/msgtab/repository/MsgCenterRepository$FastRequestCallback;", "genRequest", "Lcom/baidu/tbadk/net/FastRequest;", "context", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "getCacheKey", "type", "Lcom/baidu/tieba/immessagecenter/msgtab/data/CacheDataType;", "getDataFromCache", "getLastRequestDataCache", "getLocalForumIds", "mergeForumDataToLocal", "networkForumData", "removeFromSp", "", "key", "requestChannelData", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Function1;", "requestChannelLocalData", "saveOrUpdate", "value", "FastRequestCallback", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterRepository extends BaseRepository {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public final Map<String, ForumListData> b;
    public final Lazy c;

    /* loaded from: classes6.dex */
    public final class a extends FastRequest.b<ForumListData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Function1<? super ForumListData, Unit> b;
        public final /* synthetic */ MsgCenterRepository c;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(MsgCenterRepository msgCenterRepository) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgCenterRepository};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = msgCenterRepository;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(ForumListData result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.e(result);
                ForumListData h = this.c.h(result);
                if (h != null) {
                    Function1<? super ForumListData, Unit> function1 = this.b;
                    if (function1 != null) {
                        function1.invoke(h);
                    }
                    this.b = null;
                }
            }
        }

        public final void h(Function1<? super ForumListData, Unit> function1) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, function1) == null) {
                this.b = function1;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
            if (r5 == null) goto L13;
         */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(int i, String errMsg, ForumListData forumListData) {
            Unit unit;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, forumListData) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.b(i, errMsg, forumListData);
                ForumListData d = this.c.d();
                if (d != null) {
                    Function1<? super ForumListData, Unit> function1 = this.b;
                    if (function1 != null) {
                        function1.invoke(d);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                }
                Function1<? super ForumListData, Unit> function12 = this.b;
                if (function12 != null) {
                    function12.invoke(this.c.e());
                    Unit unit2 = Unit.INSTANCE;
                }
                this.b = null;
            }
        }
    }

    public MsgCenterRepository() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
        this.b = new LinkedHashMap();
        this.c = LazyKt__LazyJVMKt.lazy(MsgCenterRepository$_spInstance$2.INSTANCE);
    }

    public final FastRequest b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbPageContext)) == null) {
            FastRequest fastRequest = new FastRequest(tbPageContext, CmdConfigHttp.CMD_REQUEST_FOLLOWED_FRS_LIST, TbConfig.REQUEST_FOLLOWED_FRS_LIST);
            fastRequest.T(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.Q(this.a);
            return fastRequest;
        }
        return (FastRequest) invokeL.objValue;
    }

    public final String c(CacheDataType cacheDataType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cacheDataType)) == null) {
            return TbadkCoreApplication.getCurrentAccountId() + "_msg_tab_recom_data_" + cacheDataType.name();
        }
        return (String) invokeL.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (g().contains(str)) {
                g().edit().remove(str).apply();
            }
            this.b.remove(str);
        }
    }

    public final void k(Function1<? super ForumListData, Unit> block) {
        Unit unit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, block) == null) {
            Intrinsics.checkNotNullParameter(block, "block");
            ForumListData d = d();
            if (d != null) {
                block.invoke(d);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                block.invoke(e());
            }
        }
    }

    public final ForumListData d() {
        InterceptResult invokeV;
        String string;
        ForumListData forumListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String c = c(CacheDataType.RECOMMEND_DATA);
            ForumListData forumListData2 = this.b.get(c);
            if (forumListData2 != null) {
                return forumListData2;
            }
            try {
                if (!g().contains(c) || (string = g().getString(c, "")) == null || (forumListData = (ForumListData) DataExt.toEntity(string, ForumListData.class)) == null) {
                    return null;
                }
                this.b.put(c, forumListData);
                return forumListData;
            } catch (Exception e) {
                bk8.a.a("MsgCenterContainerPresenter->获取本地存储的推荐数据失败", e);
            }
        } else {
            return (ForumListData) invokeV.objValue;
        }
        return null;
    }

    public final ForumListData e() {
        InterceptResult invokeV;
        String string;
        ForumListData forumListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String c = c(CacheDataType.LAST_REQUEST_DATA);
            ForumListData forumListData2 = this.b.get(c);
            if (forumListData2 != null) {
                return forumListData2;
            }
            try {
                if (!g().contains(c) || (string = g().getString(c, "")) == null || (forumListData = (ForumListData) DataExt.toEntity(string, ForumListData.class)) == null) {
                    return null;
                }
                this.b.put(c, forumListData);
                return forumListData;
            } catch (Exception e) {
                bk8.a.a("MsgCenterContainerPresenter->获取本地存储的最后一次网络请求数据失败", e);
            }
        } else {
            return (ForumListData) invokeV.objValue;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String f() {
        InterceptResult invokeV;
        String str;
        boolean z;
        boolean z2;
        List<MsgTabForumData> forumData;
        Iterator<T> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ForumListData d = d();
            if (d != null) {
                Integer isRecom = d.isRecom();
                if (isRecom != null && isRecom.intValue() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    d = null;
                }
                if (d != null && (forumData = d.getForumData()) != null) {
                    str = "";
                    while (forumData.iterator().hasNext()) {
                        str = str + ((MsgTabForumData) it.next()).getForumId() + ',';
                    }
                    if (str.length() <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return "";
                    }
                    String substring = str.substring(0, str.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return substring;
                }
            }
            str = "";
            if (str.length() <= 0) {
            }
            if (z) {
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    public final SharedPreferences g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (SharedPreferences) this.c.getValue();
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public final ForumListData h(ForumListData forumListData) {
        InterceptResult invokeL;
        List<MsgTabForumData> list;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, forumListData)) == null) {
            String c = c(CacheDataType.RECOMMEND_DATA);
            ForumListData d = d();
            if (forumListData == null) {
                return d;
            }
            l(c(CacheDataType.LAST_REQUEST_DATA), forumListData);
            Integer isRecom = forumListData.isRecom();
            if (isRecom == null || isRecom.intValue() != 1) {
                i(c);
                return forumListData;
            }
            if (d != null) {
                list = d.getForumData();
            } else {
                list = null;
            }
            if (list == null) {
                l(c, forumListData);
                return forumListData;
            }
            List<MsgTabForumData> forumData = forumListData.getForumData();
            if (forumData != null) {
                for (MsgTabForumData msgTabForumData : forumData) {
                    Iterator<T> it = d.getForumData().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (((MsgTabForumData) obj).getForumId() == msgTabForumData.getForumId()) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    MsgTabForumData msgTabForumData2 = (MsgTabForumData) obj;
                    if (msgTabForumData2 != null) {
                        msgTabForumData2.setIcon(msgTabForumData.getIcon());
                        msgTabForumData2.setHotNumsText(msgTabForumData.getHotNumsText());
                        msgTabForumData2.setAtMe(msgTabForumData.isAtMe());
                    }
                }
            }
            l(c, d);
            return d;
        }
        return (ForumListData) invokeL.objValue;
    }

    public final void j(TbPageContext<BaseFragmentActivity> context, Function1<? super ForumListData, Unit> block) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, block) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(block, "block");
            this.a.h(block);
            FastRequest b = b(context);
            b.O(TiebaStatic.Params.FORUM_ID_MERGE, f());
            b.P();
        }
    }

    public final ForumListData l(String str, ForumListData forumListData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, forumListData)) == null) {
            g().edit().putString(str, DataExt.toJson(forumListData)).apply();
            this.b.put(str, forumListData);
            return forumListData;
        }
        return (ForumListData) invokeLL.objValue;
    }
}
