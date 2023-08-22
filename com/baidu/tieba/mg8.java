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
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
import com.baidu.tieba.lg8;
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
import protobuf.NewpushRepair;
/* loaded from: classes7.dex */
public class mg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mg8 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean a;
    public final lg8 b;
    public final lg8 c;
    public final lg8 d;
    public CustomMessage<String> e;
    public BdUniqueId f;
    public CustomMessageListener g;

    /* loaded from: classes7.dex */
    public class a implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public a(mg8 mg8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, list};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public b(mg8 mg8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, list};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && (next.getIsFriend() == 0 || next.getIsFriend() == 3)) {
                        if (next.getShowOutOfStranger() == 0) {
                            this.a.add(next);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public c(mg8 mg8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, list};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && (next.getIsFriend() == 1 || next.getIsFriend() == 2 || next.getShowOutOfStranger() == 1)) {
                        if (next.getIs_hidden() == 0) {
                            this.a.add(next);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public d(mg8 mg8Var, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, imMessageCenterPojo};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && (next.getIsFriend() == 0 || next.getIsFriend() == 3)) {
                        if (next.getIs_hidden() == 0 && next.getShowOutOfStranger() == 0) {
                            if (this.a.getLast_content_time() < next.getLast_content_time()) {
                                this.a.setLast_content(next.getLast_content());
                                this.a.setLast_content_time(next.getLast_content_time());
                                this.a.setLast_rid(next.getLast_rid());
                                this.a.setLast_user_name(next.getLast_user_name());
                                this.a.setSend_status(next.getSend_status());
                            }
                            ImMessageCenterPojo imMessageCenterPojo = this.a;
                            imMessageCenterPojo.setUnread_count(imMessageCenterPojo.getUnread_count() + next.getUnread_count());
                            this.a.setIs_hidden(0);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends bx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public e(mg8 mg8Var, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, imMessageCenterPojo};
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

        @Override // com.baidu.tieba.bx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qe8.f().k(this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public f(mg8 mg8Var, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, imMessageCenterPojo};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                        if (this.a.getLast_content_time() < next.getLast_content_time()) {
                            this.a.setLast_content(next.getLast_content());
                            this.a.setLast_content_time(next.getLast_content_time());
                            this.a.setLast_rid(next.getLast_rid());
                            this.a.setLast_user_name(next.getLast_user_name());
                        }
                        this.a.setIs_hidden(0);
                        ImMessageCenterPojo imMessageCenterPojo = this.a;
                        imMessageCenterPojo.setUnread_count(imMessageCenterPojo.getUnread_count() + next.getUnread_count());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(mg8 mg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var};
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
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo.setCustomGroupType(-8);
                imMessageCenterPojo.setIs_hidden(1);
                qe8.f().k(imMessageCenterPojo);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LongSparseArray a;
        public final /* synthetic */ mg8 b;

        public h(mg8 mg8Var, LongSparseArray longSparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, longSparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mg8Var;
            this.a = longSparseArray;
        }

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (this.b.x(next)) {
                        this.a.put(JavaTypesHelper.toLong(next.getGid(), 0L), Long.valueOf(ti8.c(next.getPulled_msgId())));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ NewpushRepair.Builder b;

        public i(mg8 mg8Var, List list, NewpushRepair.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, list, builder};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    long j = JavaTypesHelper.toLong(next.getGid(), 0L);
                    long sid = next.getSid();
                    if (sid > 0) {
                        this.a.add(MessageUtils.makeNewpushGroupRepair(j, next.getUserType(), sid, 0L, ti8.c(next.getPulled_msgId())));
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

    /* loaded from: classes7.dex */
    public class j implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(mg8 mg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var};
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
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                String data = customMessage.getData();
                qi8.a("run MEMORY_GET_FROM_DB Task：" + data);
                ue8.a();
                LinkedList<ImMessageCenterPojo> d = qe8.f().d();
                qi8.a("从" + data + ".db数据库中的tb_message_center表中获得所有数据List:");
                long c = xd8.b().c(11L);
                long c2 = xd8.b().c(12L);
                if (d == null) {
                    d = new LinkedList<>();
                }
                if (c != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    d.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(ti8.a(c));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (c2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    d.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(ti8.a(c2));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(d, data);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mg8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(mg8 mg8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, Integer.valueOf(i)};
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
            this.a = mg8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                qi8.a("onMessage MEMORY_GET_FROM_DB：mInitFromDBListener");
                yg8.e().b();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (!TextUtils.isEmpty(uid) && uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    try {
                        for (ImMessageCenterPojo imMessageCenterPojo : memoryGetFromDBMessage.getData()) {
                            if (!this.a.x(imMessageCenterPojo) || imMessageCenterPojo.getPulled_msgId() > 0) {
                                if (JavaTypesHelper.toLong(imMessageCenterPojo.getGid(), 0L) != 0) {
                                    if (imMessageCenterPojo.getCustomGroupType() == -9 && imMessageCenterPojo.getPushIds() != null && imMessageCenterPojo.getPushIds().length() > 0) {
                                        yg8.e().j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getPushIds());
                                    }
                                    this.a.C(imMessageCenterPojo);
                                }
                            }
                        }
                        this.a.u(false);
                        this.a.p(false);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    this.a.a.set(true);
                    this.a.I();
                    return;
                }
                List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                if (data != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : data) {
                        if (imMessageCenterPojo2 != null && ng8.b(imMessageCenterPojo2.getCustomGroupType()) && imMessageCenterPojo2.getPulled_msgId() > 0) {
                            this.a.C(imMessageCenterPojo2);
                        }
                    }
                }
                this.a.a.set(true);
                this.a.I();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(mg8 mg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setIs_hidden(1);
                    next.setLast_content("");
                    next.setLast_content_time(0L);
                    next.setLast_user_name("");
                    next.setUnread_count(0);
                    next.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(mg8 mg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setIs_hidden(1);
                    next.setLast_content("");
                    next.setLast_content_time(0L);
                    next.setLast_user_name("");
                    next.setUnread_count(0);
                    next.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n(mg8 mg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setIs_hidden(1);
                    next.setLast_content("");
                    next.setLast_content_time(0L);
                    next.setLast_user_name("");
                    next.setUnread_count(0);
                    next.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public o(mg8 mg8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, list};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public p(mg8 mg8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, list};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public q(mg8 mg8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, list};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements lg8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public r(mg8 mg8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg8Var, list};
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

        @Override // com.baidu.tieba.lg8.a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    public mg8() {
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
        this.b = new lg8();
        this.c = new lg8();
        this.d = new lg8();
        this.g = new k(this, 2016008);
        MessageManager.getInstance().registerListener(this.g);
        this.e = new CustomMessage<>(2016008, TbadkCoreApplication.getCurrentAccount());
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.e.setTag(gen);
    }

    public final void A(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, imMessageCenterPojo, z) != null) || !this.a.get()) {
            return;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 2) {
            L(imMessageCenterPojo, z, 1);
        } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
            K(imMessageCenterPojo, z, 1);
        } else {
            H(imMessageCenterPojo, z, 1);
        }
    }

    public void D(String str, int i2) {
        ImMessageCenterPojo h2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, str, i2) != null) || (h2 = h(str, i2)) == null) {
            return;
        }
        E(str, i2);
        B(h2);
    }

    public void E(String str, int i2) {
        lg8 m2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) && this.a.get() && (m2 = m(i2)) != null) {
            m2.e(str);
        }
    }

    public void g(String str, int i2) {
        ImMessageCenterPojo h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048597, this, str, i2) == null) && (h2 = h(str, i2)) != null) {
            h2.setUnread_count(0);
            A(h2, false);
        }
    }

    public ImMessageCenterPojo h(String str, int i2) {
        InterceptResult invokeLI;
        lg8 m2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, str, i2)) == null) {
            if (!this.a.get() || (m2 = m(i2)) == null) {
                return null;
            }
            return m2.c(str);
        }
        return (ImMessageCenterPojo) invokeLI.objValue;
    }

    public long o(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, str, i2)) == null) {
            ImMessageCenterPojo h2 = h(str, i2);
            if (h2 != null) {
                return h2.getPulled_msgId();
            }
            return 0L;
        }
        return invokeLI.longValue;
    }

    public final void C(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo) != null) || imMessageCenterPojo == null) {
            return;
        }
        m(imMessageCenterPojo.getCustomGroupType()).a(imMessageCenterPojo);
    }

    public void S(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, imMessageCenterPojo) == null) {
            A(T(imMessageCenterPojo), false);
        }
    }

    public final lg8 m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            if (i2 == 2) {
                return this.c;
            }
            if (i2 == 4) {
                return this.d;
            }
            return this.b;
        }
        return (lg8) invokeI.objValue;
    }

    public final boolean x(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            return ng8.a(imMessageCenterPojo.getCustomGroupType());
        }
        return invokeL.booleanValue;
    }

    public static mg8 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (h == null) {
                synchronized (mg8.class) {
                    if (h == null) {
                        h = new mg8();
                    }
                }
            }
            return h;
        }
        return (mg8) invokeV.objValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016001));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            qi8.a("sendInitCompletedMessage：发送内存初始化完成的消息");
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            H(p(false), false, 1);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            H(u(false), false, 1);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.b.b();
            this.c.b();
            this.d.b();
            G();
        }
    }

    public List<ImMessageCenterPojo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.b.d(new r(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.d.d(new a(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.c.d(new b(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public LongSparseArray<Long> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
            if (this.a.get()) {
                this.b.d(new h(this, longSparseArray));
            }
            return longSparseArray;
        }
        return (LongSparseArray) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.c.d(new c(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.a.get();
        }
        return invokeV.booleanValue;
    }

    public final void B(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo) != null) || !this.a.get()) {
            return;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 2) {
            H(imMessageCenterPojo, false, 2);
            H(u(false), false, 1);
        } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
            H(imMessageCenterPojo, false, 2);
            H(p(false), false, 1);
        } else {
            H(imMessageCenterPojo, false, 2);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.a.get()) {
            return;
        }
        this.b.d(new l(this));
        this.c.d(new m(this));
        this.d.d(new n(this));
        G();
    }

    public List<ImMessageCenterPojo> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.b.d(new o(this, linkedList));
            this.c.d(new p(this, linkedList));
            this.d.d(new q(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public NewpushRepair r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            NewpushRepair.Builder builder = new NewpushRepair.Builder();
            ArrayList arrayList = new ArrayList();
            if (this.a.get()) {
                this.d.d(new i(this, arrayList, builder));
            }
            return builder.build(false);
        }
        return (NewpushRepair) invokeV.objValue;
    }

    public void H(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i2));
        }
    }

    public ImMessageCenterPojo z(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ImMessageCenterPojo h2 = h(str, i2);
            if (h2 != null) {
                if (z) {
                    h2.setIs_hidden(0);
                } else {
                    h2.setIs_hidden(1);
                }
            }
            return h2;
        }
        return (ImMessageCenterPojo) invokeCommon.objValue;
    }

    public final void K(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            H(imMessageCenterPojo, z, i2);
            H(p(z), z, i2);
        }
    }

    public void L(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            H(imMessageCenterPojo, z, i2);
            H(u(z), z, i2);
        }
    }

    public void y(String str, int i2, boolean z) {
        ImMessageCenterPojo z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && (z2 = z(str, i2, z)) != null) {
            A(z2, false);
        }
    }

    public void N(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, imMessageCenterPojo) != null) || !this.a.get()) {
            return;
        }
        ImMessageCenterPojo h2 = h(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
        if (h2 == null) {
            C(imMessageCenterPojo);
            A(imMessageCenterPojo, true);
        } else if (imMessageCenterPojo.getLast_rid() >= h2.getLast_rid()) {
            E(h2.getGid(), h2.getCustomGroupType());
            if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                imMessageCenterPojo.setGroup_head(h2.getGroup_head());
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                imMessageCenterPojo.setGroup_name(h2.getGroup_name());
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                imMessageCenterPojo.setNameShow(h2.getNameShow());
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                imMessageCenterPojo.setBjhAvatar(h2.getBjhAvatar());
            }
            C(imMessageCenterPojo);
            A(imMessageCenterPojo, true);
        } else {
            h2.setRead_msgId(imMessageCenterPojo.getRead_msgId());
        }
    }

    public final ImMessageCenterPojo u(boolean z) {
        InterceptResult invokeZ;
        ImMessageCenterPojo imMessageCenterPojo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
            lg8 m2 = m(-7);
            if (m2 != null) {
                imMessageCenterPojo = m2.c(TbEnum.CustomGroupId.STRANGE_MERGE);
            } else {
                imMessageCenterPojo = null;
            }
            if (imMessageCenterPojo == null) {
                imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                imMessageCenterPojo.setCustomGroupType(-7);
                C(imMessageCenterPojo);
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
                    ImMessageCenterPojo h2 = h(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                    if (h2 != null) {
                        fx5.c(new e(this, h2), null);
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

    public void O(int i2, long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str}) != null) || !this.a.get()) {
            return;
        }
        ImMessageCenterPojo h2 = h(str, i2);
        if (h2 == null) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i2);
            imMessageCenterPojo.setPulled_msgId(j2);
            imMessageCenterPojo.setGid(str);
            C(imMessageCenterPojo);
        } else if (h2.getPulled_msgId() < j2) {
            h2.setPulled_msgId(j2);
        }
    }

    public void P(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, imMessageCenterPojo) == null) && this.a.get() && imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ImMessageCenterPojo h2 = h(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (h2 == null) {
                C(imMessageCenterPojo);
            } else if (h2.getPulled_msgId() <= 0 && imMessageCenterPojo.getPulled_msgId() > 0) {
                h2.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            }
        }
    }

    public void R(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, imMessageCenterPojo) != null) || !this.a.get() || imMessageCenterPojo == null) {
            return;
        }
        ImMessageCenterPojo h2 = h(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
        if (h2 == null) {
            C(imMessageCenterPojo);
            return;
        }
        h2.setGroup_head(imMessageCenterPojo.getGroup_head());
        h2.setGroup_name(imMessageCenterPojo.getGroup_name());
        h2.setNameShow(imMessageCenterPojo.getNameShow());
        h2.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
    }

    public ImMessageCenterPojo T(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, imMessageCenterPojo)) == null) {
            if (!this.a.get() || imMessageCenterPojo == null) {
                return null;
            }
            ImMessageCenterPojo h2 = h(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (h2 == null) {
                C(imMessageCenterPojo);
            } else {
                E(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
                imMessageCenterPojo.setPulled_msgId(h2.getPulled_msgId());
                C(imMessageCenterPojo);
            }
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }

    public void Q(int i2, ChatMessage chatMessage, String str, int i3) {
        int userType;
        ImMessageCenterPojo h2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), chatMessage, str, Integer.valueOf(i3)}) != null) || !this.a.get()) {
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
        ImMessageCenterPojo h3 = h(str, i2);
        if (h3 == null) {
            h3 = new ImMessageCenterPojo();
            h3.setCustomGroupType(i2);
            h3.setGid(str);
            C(h3);
        }
        if (i2 == 2 || i2 == 4) {
            if (userData != null) {
                if (!TextUtils.isEmpty(userData.getPortrait())) {
                    h3.setGroup_head(userData.getPortrait());
                }
                if (!TextUtils.isEmpty(userData.getUserName())) {
                    h3.setGroup_name(userData.getUserName());
                }
                if (!TextUtils.isEmpty(userData.getName_show())) {
                    h3.setNameShow(userData.getName_show());
                }
                if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                    h3.setBjhAvatar(userData.getImBjhAvatar());
                }
            }
            if (chatMessage != null) {
                if (JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                    userType = chatMessage.getUserInfo().getUserType();
                } else {
                    userType = chatMessage.getToUserInfo().getUserType();
                }
                h3.setUserType(userType);
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (chatMessage != null && h3.getLast_rid() <= chatMessage.getRecordId()) {
                        h3.setLast_content_time(chatMessage.getTime() * 1000);
                        h3.setLast_content(ui8.D(chatMessage.getMsgType(), chatMessage.getContent()));
                        h3.setLast_user_name(chatMessage.getUserInfo().getName_show());
                        h3.setLast_rid(chatMessage.getRecordId());
                        h3.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                        h3.setIsFriend(chatMessage.getIsFriend());
                        h3.setFollowStatus(chatMessage.getFollowStatus());
                        if (chatMessage.getLocalData() != null) {
                            h3.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                        }
                    }
                    h3.setIs_hidden(0);
                    h3.setShowOutOfStranger(1);
                    if (i2 == 4 && (h2 = h(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                        h2.setIs_hidden(0);
                    }
                }
            } else if (chatMessage != null) {
                h3.setLast_content_time(chatMessage.getTime() * 1000);
                h3.setLast_content(ui8.D(chatMessage.getMsgType(), chatMessage.getContent()));
                h3.setLast_user_name(chatMessage.getUserInfo().getName_show());
                h3.setLast_rid(chatMessage.getRecordId());
                h3.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                h3.setIsFriend(chatMessage.getIsFriend());
                h3.setFollowStatus(chatMessage.getFollowStatus());
                if (chatMessage.getLocalData() != null) {
                    h3.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                }
            } else {
                h3.setLast_content("");
                h3.setLast_rid(0L);
                h3.setSend_status(0);
                h3.setUnread_count(0);
            }
        } else {
            h3.setLast_content("");
            h3.setLast_rid(0L);
            h3.setSend_status(0);
            h3.setUnread_count(0);
        }
        BdLog.i("send message status " + h3.getSend_status());
        A(h3, false);
    }

    public final ImMessageCenterPojo p(boolean z) {
        InterceptResult invokeZ;
        ImMessageCenterPojo imMessageCenterPojo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
            lg8 m2 = m(-8);
            if (m2 != null) {
                imMessageCenterPojo = m2.c(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            } else {
                imMessageCenterPojo = null;
            }
            if (imMessageCenterPojo == null) {
                imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo.setCustomGroupType(-8);
                C(imMessageCenterPojo);
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

    public long s(String str, int i2) {
        InterceptResult invokeLI;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, str, i2)) == null) {
            ImMessageCenterPojo h2 = h(str, i2);
            if (h2 != null) {
                if (h2.getLast_rid() > h2.getPulled_msgId()) {
                    j2 = h2.getLast_rid();
                } else {
                    j2 = h2.getPulled_msgId();
                }
            } else {
                j2 = 0;
            }
            return j2 + 1;
        }
        return invokeLI.longValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.a.set(false);
            f();
            MessageManager.getInstance().removeMessage(2016008, this.f);
            this.e.setData(TbadkCoreApplication.getCurrentAccount());
            CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new j(this));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            qi8.a("ImMemoryCacheManager.getInstance().init()");
            MessageManager.getInstance().sendMessage(this.e, customMessageTask);
        }
    }
}
