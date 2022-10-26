package com.baidu.tieba;

import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.ta7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes6.dex */
public class ua7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ua7 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean a;
    public final ta7 b;
    public final ta7 c;
    public final ta7 d;
    public CustomMessage e;
    public BdUniqueId f;
    public CustomMessageListener g;

    /* loaded from: classes6.dex */
    public class a implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public a(ua7 ua7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public b(ua7 ua7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                    if (imMessageCenterPojo.getCustomGroupType() == 2 && (imMessageCenterPojo.getIsFriend() == 0 || imMessageCenterPojo.getIsFriend() == 3)) {
                        if (imMessageCenterPojo.getShowOutOfStranger() == 0) {
                            this.a.add(imMessageCenterPojo);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public c(ua7 ua7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                    if (imMessageCenterPojo.getCustomGroupType() == 2 && (imMessageCenterPojo.getIsFriend() == 1 || imMessageCenterPojo.getIsFriend() == 2 || imMessageCenterPojo.getShowOutOfStranger() == 1)) {
                        if (imMessageCenterPojo.getIs_hidden() == 0) {
                            this.a.add(imMessageCenterPojo);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public d(ua7 ua7Var, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterPojo;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                    if (imMessageCenterPojo.getCustomGroupType() == 2 && (imMessageCenterPojo.getIsFriend() == 0 || imMessageCenterPojo.getIsFriend() == 3)) {
                        if (imMessageCenterPojo.getIs_hidden() == 0 && imMessageCenterPojo.getShowOutOfStranger() == 0) {
                            if (this.a.getLast_content_time() < imMessageCenterPojo.getLast_content_time()) {
                                this.a.setLast_content(imMessageCenterPojo.getLast_content());
                                this.a.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                                this.a.setLast_rid(imMessageCenterPojo.getLast_rid());
                                this.a.setLast_user_name(imMessageCenterPojo.getLast_user_name());
                                this.a.setSend_status(imMessageCenterPojo.getSend_status());
                            }
                            ImMessageCenterPojo imMessageCenterPojo2 = this.a;
                            imMessageCenterPojo2.setUnread_count(imMessageCenterPojo2.getUnread_count() + imMessageCenterPojo.getUnread_count());
                            this.a.setIs_hidden(0);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends ii5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public e(ua7 ua7Var, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterPojo;
        }

        @Override // com.baidu.tieba.ii5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                da7.f().k(this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public f(ua7 ua7Var, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterPojo;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                    if (imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getIs_hidden() == 0 && (imMessageCenterPojo.getUserType() == 1 || imMessageCenterPojo.getUserType() == 3)) {
                        if (this.a.getLast_content_time() < imMessageCenterPojo.getLast_content_time()) {
                            this.a.setLast_content(imMessageCenterPojo.getLast_content());
                            this.a.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                            this.a.setLast_rid(imMessageCenterPojo.getLast_rid());
                            this.a.setLast_user_name(imMessageCenterPojo.getLast_user_name());
                        }
                        this.a.setIs_hidden(0);
                        ImMessageCenterPojo imMessageCenterPojo2 = this.a;
                        imMessageCenterPojo2.setUnread_count(imMessageCenterPojo2.getUnread_count() + imMessageCenterPojo.getUnread_count());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(ua7 ua7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage run(CustomMessage customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo.setCustomGroupType(-8);
                imMessageCenterPojo.setIs_hidden(1);
                da7.f().k(imMessageCenterPojo);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LongSparseArray a;
        public final /* synthetic */ ua7 b;

        public h(ua7 ua7Var, LongSparseArray longSparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, longSparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ua7Var;
            this.a = longSparseArray;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                    if (this.b.z(imMessageCenterPojo)) {
                        this.a.put(eh.g(imMessageCenterPojo.getGid(), 0L), Long.valueOf(ad7.c(imMessageCenterPojo.getPulled_msgId())));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ NewpushRepair.Builder b;

        public i(ua7 ua7Var, List list, NewpushRepair.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, list, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = builder;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                    long g = eh.g(imMessageCenterPojo.getGid(), 0L);
                    long sid = imMessageCenterPojo.getSid();
                    if (sid > 0) {
                        this.a.add(MessageUtils.makeNewpushGroupRepair(g, imMessageCenterPojo.getUserType(), sid, 0L, ad7.c(imMessageCenterPojo.getPulled_msgId())));
                    }
                }
                if (this.a.size() <= 10) {
                    this.b.groups = this.a;
                    return;
                }
                this.b.followType = "0";
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(ua7 ua7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage run(CustomMessage customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                String str = (String) customMessage.getData();
                wc7.a("run MEMORY_GET_FROM_DB Task：" + str);
                ha7.a();
                LinkedList d = da7.f().d();
                wc7.a("从" + str + ".db数据库中的tb_message_center表中获得所有数据List:");
                long c = l97.b().c(11L);
                long c2 = l97.b().c(12L);
                if (d == null) {
                    d = new LinkedList();
                }
                if (c != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    d.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(ad7.a(c));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (c2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    d.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(ad7.a(c2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(d, str);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ua7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ua7 ua7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, Integer.valueOf(i)};
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
            this.a = ua7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                wc7.a("onMessage MEMORY_GET_FROM_DB：mInitFromDBListener");
                hb7.e().b();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (!TextUtils.isEmpty(uid) && uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    try {
                        for (ImMessageCenterPojo imMessageCenterPojo : (List) memoryGetFromDBMessage.getData()) {
                            if (!this.a.z(imMessageCenterPojo) || imMessageCenterPojo.getPulled_msgId() > 0) {
                                if (eh.g(imMessageCenterPojo.getGid(), 0L) != 0) {
                                    if (imMessageCenterPojo.getCustomGroupType() == -9 && imMessageCenterPojo.getPushIds() != null && imMessageCenterPojo.getPushIds().length() > 0) {
                                        hb7.e().j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getPushIds());
                                    }
                                    this.a.E(imMessageCenterPojo);
                                }
                            }
                        }
                        this.a.v(false);
                        this.a.q(false);
                        this.a.x();
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    this.a.a.set(true);
                    this.a.L();
                    return;
                }
                List<ImMessageCenterPojo> list = (List) memoryGetFromDBMessage.getData();
                if (list != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : list) {
                        if (imMessageCenterPojo2 != null && va7.b(imMessageCenterPojo2.getCustomGroupType()) && imMessageCenterPojo2.getPulled_msgId() > 0) {
                            this.a.E(imMessageCenterPojo2);
                        }
                    }
                }
                this.a.a.set(true);
                this.a.L();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(ua7 ua7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                    imMessageCenterPojo.setIs_hidden(1);
                    imMessageCenterPojo.setLast_content("");
                    imMessageCenterPojo.setLast_content_time(0L);
                    imMessageCenterPojo.setLast_user_name("");
                    imMessageCenterPojo.setUnread_count(0);
                    imMessageCenterPojo.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(ua7 ua7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                    imMessageCenterPojo.setIs_hidden(1);
                    imMessageCenterPojo.setLast_content("");
                    imMessageCenterPojo.setLast_content_time(0L);
                    imMessageCenterPojo.setLast_user_name("");
                    imMessageCenterPojo.setUnread_count(0);
                    imMessageCenterPojo.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n(ua7 ua7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                    imMessageCenterPojo.setIs_hidden(1);
                    imMessageCenterPojo.setLast_content("");
                    imMessageCenterPojo.setLast_content_time(0L);
                    imMessageCenterPojo.setLast_user_name("");
                    imMessageCenterPojo.setUnread_count(0);
                    imMessageCenterPojo.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public o(ua7 ua7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public p(ua7 ua7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public q(ua7 ua7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements ta7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public r(ua7 ua7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // com.baidu.tieba.ta7.a
        public void a(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    public ua7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        this.b = new ta7();
        this.c = new ta7();
        this.d = new ta7();
        this.g = new k(this, 2016008);
        MessageManager.getInstance().registerListener(this.g);
        this.e = new CustomMessage(2016008, TbadkCoreApplication.getCurrentAccount());
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.e.setTag(gen);
    }

    public void F(String str, int i2) {
        ImMessageCenterPojo i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, str, i2) != null) || (i3 = i(str, i2)) == null) {
            return;
        }
        G(str, i2);
        D(i3);
    }

    public void G(String str, int i2) {
        ta7 n2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) && this.a.get() && (n2 = n(i2)) != null) {
            n2.e(str);
        }
    }

    public void Q(String str, String str2) {
        ImMessageCenterPojo i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) && (i2 = i(str, 1)) != null) {
            i2.setGroup_head(str2);
            C(i2, false);
        }
    }

    public void R(String str, String str2) {
        ImMessageCenterPojo i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) && (i2 = i(str, 1)) != null) {
            i2.setGroup_name(str2);
            C(i2, false);
        }
    }

    public void h(String str, int i2) {
        ImMessageCenterPojo i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048603, this, str, i2) == null) && (i3 = i(str, i2)) != null) {
            i3.setUnread_count(0);
            C(i3, false);
        }
    }

    public ImMessageCenterPojo i(String str, int i2) {
        InterceptResult invokeLI;
        ta7 n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, str, i2)) == null) {
            if (!this.a.get() || (n2 = n(i2)) == null) {
                return null;
            }
            return n2.c(str);
        }
        return (ImMessageCenterPojo) invokeLI.objValue;
    }

    public long p(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, str, i2)) == null) {
            ImMessageCenterPojo i3 = i(str, i2);
            if (i3 != null) {
                return i3.getPulled_msgId();
            }
            return 0L;
        }
        return invokeLI.longValue;
    }

    public final void E(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, imMessageCenterPojo) != null) || imMessageCenterPojo == null) {
            return;
        }
        n(imMessageCenterPojo.getCustomGroupType()).a(imMessageCenterPojo);
    }

    public void Y(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, imMessageCenterPojo) == null) {
            C(Z(imMessageCenterPojo), false);
        }
    }

    public final ta7 n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            if (i2 == 2) {
                return this.c;
            }
            if (i2 == 4) {
                return this.d;
            }
            return this.b;
        }
        return (ta7) invokeI.objValue;
    }

    public final boolean z(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            return va7.a(imMessageCenterPojo.getCustomGroupType());
        }
        return invokeL.booleanValue;
    }

    public static ua7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (h == null) {
                synchronized (ua7.class) {
                    if (h == null) {
                        h = new ua7();
                    }
                }
            }
            return h;
        }
        return (ua7) invokeV.objValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016001));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            wc7.a("sendInitCompletedMessage：发送内存初始化完成的消息");
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            K(q(false), false, 1);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            K(v(false), false, 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.b.b();
            this.c.b();
            this.d.b();
            J();
        }
    }

    public List j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.b.d(new r(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.d.d(new a(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.c.d(new b(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public LongSparseArray r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            if (this.a.get()) {
                this.b.d(new h(this, longSparseArray));
            }
            return longSparseArray;
        }
        return (LongSparseArray) invokeV.objValue;
    }

    public List u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.c.d(new c(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.a.get();
        }
        return invokeV.booleanValue;
    }

    public void A(String str, int i2, boolean z) {
        ImMessageCenterPojo B;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && (B = B(str, i2, z)) != null) {
            C(B, false);
        }
    }

    public final void N(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            K(imMessageCenterPojo, z, i2);
            K(q(z), z, i2);
        }
    }

    public void O(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            K(imMessageCenterPojo, z, i2);
            K(v(z), z, i2);
        }
    }

    public ImMessageCenterPojo B(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ImMessageCenterPojo i3 = i(str, i2);
            if (i3 != null) {
                if (z) {
                    i3.setIs_hidden(0);
                } else {
                    i3.setIs_hidden(1);
                }
            }
            return i3;
        }
        return (ImMessageCenterPojo) invokeCommon.objValue;
    }

    public void K(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i2));
        }
    }

    public final void C(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo, z) != null) || !this.a.get()) {
            return;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 2) {
            O(imMessageCenterPojo, z, 1);
        } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
            N(imMessageCenterPojo, z, 1);
        } else {
            K(imMessageCenterPojo, z, 1);
        }
    }

    public long t(String str, int i2) {
        InterceptResult invokeLI;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048614, this, str, i2)) == null) {
            ImMessageCenterPojo i3 = i(str, i2);
            if (i3 != null) {
                if (i3.getLast_rid() > i3.getPulled_msgId()) {
                    j2 = i3.getLast_rid();
                } else {
                    j2 = i3.getPulled_msgId();
                }
            } else {
                j2 = 0;
            }
            return j2 + 1;
        }
        return invokeLI.longValue;
    }

    public final void D(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, imMessageCenterPojo) != null) || !this.a.get()) {
            return;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 2) {
            K(imMessageCenterPojo, false, 2);
            K(v(false), false, 1);
        } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
            K(imMessageCenterPojo, false, 2);
            K(q(false), false, 1);
        } else {
            K(imMessageCenterPojo, false, 2);
        }
    }

    public void H(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && list.size() != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) it.next();
                if (imMessageCenterPojo != null) {
                    this.b.e(imMessageCenterPojo.getGid());
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || !this.a.get()) {
            return;
        }
        this.b.d(new l(this));
        this.c.d(new m(this));
        this.d.d(new n(this));
        J();
    }

    public List k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.b.d(new o(this, linkedList));
            this.c.d(new p(this, linkedList));
            this.d.d(new q(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public NewpushRepair s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            NewpushRepair.Builder builder = new NewpushRepair.Builder();
            ArrayList arrayList = new ArrayList();
            if (this.a.get()) {
                this.d.d(new i(this, arrayList, builder));
            }
            return builder.build(false);
        }
        return (NewpushRepair) invokeV.objValue;
    }

    public void S(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, imMessageCenterPojo) != null) || !this.a.get()) {
            return;
        }
        ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
        if (i2 == null) {
            E(imMessageCenterPojo);
            C(imMessageCenterPojo, true);
        } else if (imMessageCenterPojo.getLast_rid() >= i2.getLast_rid()) {
            G(i2.getGid(), i2.getCustomGroupType());
            if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                imMessageCenterPojo.setGroup_head(i2.getGroup_head());
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                imMessageCenterPojo.setGroup_name(i2.getGroup_name());
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                imMessageCenterPojo.setNameShow(i2.getNameShow());
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                imMessageCenterPojo.setBjhAvatar(i2.getBjhAvatar());
            }
            E(imMessageCenterPojo);
            C(imMessageCenterPojo, true);
        } else {
            i2.setRead_msgId(imMessageCenterPojo.getRead_msgId());
        }
    }

    public final ImMessageCenterPojo v(boolean z) {
        InterceptResult invokeZ;
        ImMessageCenterPojo imMessageCenterPojo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) {
            ta7 n2 = n(-7);
            if (n2 != null) {
                imMessageCenterPojo = n2.c(TbEnum.CustomGroupId.STRANGE_MERGE);
            } else {
                imMessageCenterPojo = null;
            }
            if (imMessageCenterPojo == null) {
                imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                imMessageCenterPojo.setCustomGroupType(-7);
                E(imMessageCenterPojo);
            }
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setIs_hidden(1);
            this.c.d(new d(this, imMessageCenterPojo2));
            imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
            imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
            imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
            imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
            imMessageCenterPojo.setSend_status(imMessageCenterPojo2.getSend_status());
            if (imMessageCenterPojo2.getIs_hidden() == 1) {
                imMessageCenterPojo.setUnread_count(0);
                if (imMessageCenterPojo.getIs_hidden() != 1) {
                    imMessageCenterPojo.setIs_hidden(1);
                    ImMessageCenterPojo i2 = i(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                    if (i2 != null) {
                        mi5.c(new e(this, i2), null);
                    }
                }
            } else {
                if (z) {
                    if (ChatStatusManager.getInst().getIsOpen(5)) {
                        imMessageCenterPojo.setUnread_count(0);
                    } else {
                        imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
                    }
                } else if (imMessageCenterPojo.getUnread_count() > 0) {
                    imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
                }
                imMessageCenterPojo.setIs_hidden(imMessageCenterPojo2.getIs_hidden());
            }
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeZ.objValue;
    }

    public void T(ImMessageCenterPojo imMessageCenterPojo, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048595, this, imMessageCenterPojo, i2) != null) || !this.a.get() || imMessageCenterPojo == null) {
            return;
        }
        ImMessageCenterPojo i3 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
        if (i3 == null) {
            imMessageCenterPojo.setUnread_count(i2);
            E(imMessageCenterPojo);
            imMessageCenterPojo.setIs_hidden(0);
            C(imMessageCenterPojo, true);
        } else if (imMessageCenterPojo.getLast_rid() > i3.getLast_rid()) {
            i3.setLast_rid(imMessageCenterPojo.getLast_rid());
            i3.setLast_content(imMessageCenterPojo.getLast_content());
            i3.setLast_content_time(imMessageCenterPojo.getLast_content_time());
            i3.setUnread_count(i3.getUnread_count() + i2);
            i3.setIs_hidden(0);
            i3.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
            i3.setGroup_name(imMessageCenterPojo.getGroup_name());
            i3.setNameShow(imMessageCenterPojo.getNameShow());
            i3.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
            C(i3, true);
        }
    }

    public void U(int i2, long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str}) != null) || !this.a.get()) {
            return;
        }
        ImMessageCenterPojo i3 = i(str, i2);
        if (i3 == null) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i2);
            imMessageCenterPojo.setPulled_msgId(j2);
            imMessageCenterPojo.setGid(str);
            E(imMessageCenterPojo);
        } else if (i3.getPulled_msgId() < j2) {
            i3.setPulled_msgId(j2);
        }
    }

    public void V(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, imMessageCenterPojo) == null) && this.a.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (i2 == null) {
                E(imMessageCenterPojo);
            } else if (i2.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                i2.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    public void X(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, imMessageCenterPojo) != null) || !this.a.get() || imMessageCenterPojo == null) {
            return;
        }
        ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
        if (i2 == null) {
            E(imMessageCenterPojo);
            return;
        }
        i2.setGroup_head(imMessageCenterPojo.getGroup_head());
        i2.setGroup_name(imMessageCenterPojo.getGroup_name());
        i2.setNameShow(imMessageCenterPojo.getNameShow());
        i2.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
    }

    public ImMessageCenterPojo Z(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, imMessageCenterPojo)) == null) {
            if (!this.a.get() || imMessageCenterPojo == null) {
                return null;
            }
            ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (i2 == null) {
                E(imMessageCenterPojo);
            } else {
                G(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
                imMessageCenterPojo.setPulled_msgId(i2.getPulled_msgId());
                E(imMessageCenterPojo);
            }
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }

    public void W(int i2, ChatMessage chatMessage, String str, int i3) {
        int userType;
        ImMessageCenterPojo i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), chatMessage, str, Integer.valueOf(i3)}) != null) || !this.a.get()) {
            return;
        }
        UserData userData = null;
        if ((i2 == 2 || i2 == 4) && chatMessage != null) {
            if (String.valueOf(chatMessage.getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                userData = chatMessage.getToUserInfo();
            } else {
                userData = chatMessage.getUserInfo();
            }
            if (userData != null) {
                str = userData.getUserId();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ImMessageCenterPojo i5 = i(str, i2);
        if (i5 == null) {
            i5 = new ImMessageCenterPojo();
            i5.setCustomGroupType(i2);
            i5.setGid(str);
            E(i5);
        }
        if (i2 == 2 || i2 == 4) {
            if (userData != null) {
                if (!TextUtils.isEmpty(userData.getPortrait())) {
                    i5.setGroup_head(userData.getPortrait());
                }
                if (!TextUtils.isEmpty(userData.getUserName())) {
                    i5.setGroup_name(userData.getUserName());
                }
                if (!TextUtils.isEmpty(userData.getName_show())) {
                    i5.setNameShow(userData.getName_show());
                }
                if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                    i5.setBjhAvatar(userData.getImBjhAvatar());
                }
            }
            if (chatMessage != null) {
                if (eh.g(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                    userType = chatMessage.getUserInfo().getUserType();
                } else {
                    userType = chatMessage.getToUserInfo().getUserType();
                }
                i5.setUserType(userType);
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (chatMessage != null && i5.getLast_rid() <= chatMessage.getRecordId()) {
                        i5.setLast_content_time(chatMessage.getTime() * 1000);
                        i5.setLast_content(bd7.A(chatMessage.getMsgType(), chatMessage.getContent()));
                        i5.setLast_user_name(chatMessage.getUserInfo().getName_show());
                        i5.setLast_rid(chatMessage.getRecordId());
                        i5.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                        i5.setIsFriend(chatMessage.getIsFriend());
                        i5.setFollowStatus(chatMessage.getFollowStatus());
                        if (chatMessage.getLocalData() != null) {
                            i5.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                        }
                    }
                    i5.setIs_hidden(0);
                    i5.setShowOutOfStranger(1);
                    if (i2 == 4 && (i4 = i(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                        i4.setIs_hidden(0);
                    }
                }
            } else if (chatMessage != null) {
                i5.setLast_content_time(chatMessage.getTime() * 1000);
                i5.setLast_content(bd7.A(chatMessage.getMsgType(), chatMessage.getContent()));
                i5.setLast_user_name(chatMessage.getUserInfo().getName_show());
                i5.setLast_rid(chatMessage.getRecordId());
                i5.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                i5.setIsFriend(chatMessage.getIsFriend());
                i5.setFollowStatus(chatMessage.getFollowStatus());
                if (chatMessage.getLocalData() != null) {
                    i5.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                }
            } else {
                i5.setLast_content("");
                i5.setLast_rid(0L);
                i5.setSend_status(0);
                i5.setUnread_count(0);
            }
        } else {
            i5.setLast_content("");
            i5.setLast_rid(0L);
            i5.setSend_status(0);
            i5.setUnread_count(0);
        }
        BdLog.i("send message status " + i5.getSend_status());
        C(i5, false);
    }

    public final ImMessageCenterPojo q(boolean z) {
        InterceptResult invokeZ;
        ImMessageCenterPojo imMessageCenterPojo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048611, this, z)) == null) {
            ta7 n2 = n(-8);
            if (n2 != null) {
                imMessageCenterPojo = n2.c(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            } else {
                imMessageCenterPojo = null;
            }
            if (imMessageCenterPojo == null) {
                imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo.setCustomGroupType(-8);
                E(imMessageCenterPojo);
            }
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setIs_hidden(1);
            this.d.d(new f(this, imMessageCenterPojo2));
            imMessageCenterPojo.setUserType(imMessageCenterPojo2.getUserType());
            imMessageCenterPojo.setLast_content(imMessageCenterPojo2.getLast_content());
            imMessageCenterPojo.setLast_content_time(imMessageCenterPojo2.getLast_content_time());
            imMessageCenterPojo.setLast_rid(imMessageCenterPojo2.getLast_rid());
            imMessageCenterPojo.setLast_user_name(imMessageCenterPojo2.getLast_user_name());
            if (imMessageCenterPojo2.getIs_hidden() == 1) {
                imMessageCenterPojo.setUnread_count(0);
                if (imMessageCenterPojo.getIs_hidden() != 1) {
                    imMessageCenterPojo.setIs_hidden(1);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new g(this));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            } else if (z) {
                if (ChatStatusManager.getInst().getIsOpen(4)) {
                    imMessageCenterPojo.setUnread_count(0);
                } else {
                    imMessageCenterPojo.setIs_hidden(imMessageCenterPojo2.getIs_hidden());
                    imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
                }
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                imMessageCenterPojo.setUnread_count(imMessageCenterPojo2.getUnread_count());
            }
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeZ.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.a.set(false);
            g();
            MessageManager.getInstance().removeMessage(2016008, this.f);
            this.e.setData(TbadkCoreApplication.getCurrentAccount());
            CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new j(this));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            wc7.a("ImMemoryCacheManager.getInstance().init()");
            MessageManager.getInstance().sendMessage(this.e, customMessageTask);
        }
    }

    public final void x() {
        ta7 n2;
        ImMessageCenterPojo c2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048618, this) != null) || (n2 = n(-4)) == null || (c2 = n2.c(TbEnum.CustomGroupId.GROUP_VALIDATION)) == null) {
            return;
        }
        String last_content = c2.getLast_content();
        if (!TextUtils.isEmpty(last_content)) {
            try {
                JSONObject jSONObject = new JSONObject(last_content);
                JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                String str3 = "";
                if (true == jSONObject.isNull("notice_id")) {
                    if (optJSONObject == null) {
                        str2 = "";
                        str = str2;
                    } else {
                        str3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                        str = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                        str2 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                    }
                } else {
                    str3 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                    String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                    String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                    str = optString;
                    str2 = optString2;
                }
                ImMessageCenterPojo c3 = this.b.c(str3);
                if (c3 != null) {
                    str2 = c3.getGroup_name();
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    c2.setLast_content(str + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f1532) + str2);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }
}
