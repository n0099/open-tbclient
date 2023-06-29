package com.baidu.tieba;

import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimer;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class m5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947925040, "Lcom/baidu/tieba/m5a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947925040, "Lcom/baidu/tieba/m5a;");
        }
    }

    public static boolean a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            t9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.e("delete from cash_data where type=?", new String[]{String.valueOf(i)});
            return mainDBDatabaseManager.e("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
        }
        return invokeLI.booleanValue;
    }

    public static void f(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65542, null, i, str) == null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
        }
    }

    public static void i(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, null, i, str) == null) {
            t9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null) {
                if (i != 0) {
                    if (i == 1) {
                        mainDBDatabaseManager.e("delete from search_post_data where key=?", new String[]{str});
                        return;
                    }
                    return;
                }
                mainDBDatabaseManager.e("delete from search_data where key=?", new String[]{str});
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c(0);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c(1);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            e(2);
        }
    }

    public static ArrayList<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return l(0);
        }
        return (ArrayList) invokeV.objValue;
    }

    public static ArrayList<String> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return l(1);
        }
        return (ArrayList) invokeV.objValue;
    }

    public static void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            t9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (i != 0) {
                if (i == 1) {
                    mainDBDatabaseManager.d("delete from search_post_data");
                    return;
                }
                return;
            }
            mainDBDatabaseManager.d("delete from search_data");
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            f(13, str);
        }
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            i(0, str);
        }
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            p(0, str);
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            p(1, str);
        }
    }

    public static void e(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65541, null, i) != null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
    }

    public static ArrayList<String> l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            t9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor cursor = null;
            try {
                try {
                    if (i != 0) {
                        if (i == 1) {
                            cursor = mainDBDatabaseManager.j("select * from search_post_data order by time desc limit 5", null);
                        }
                    } else {
                        cursor = mainDBDatabaseManager.j("select * from search_data order by time desc limit 20", null);
                    }
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        if (string != null && string.length() > 0) {
                            arrayList.add(string);
                        }
                    }
                } catch (Exception e) {
                    mainDBDatabaseManager.i(e, "getAllSearchData");
                }
                return arrayList;
            } finally {
                ug.a(cursor);
            }
        }
        return (ArrayList) invokeI.objValue;
    }

    public static void n() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, null) == null) && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0 && TbadkCoreApplication.getCurrentAccountName() != null) {
            t9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Cursor cursor = null;
            try {
                try {
                    cursor = mainDBDatabaseManager.j("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    if (cursor != null && cursor.moveToFirst()) {
                        se5.d().O(cursor.getInt(cursor.getColumnIndex(FetchTimer.FREQUENCY)));
                        se5 d = se5.d();
                        if (cursor.getInt(cursor.getColumnIndex("fans_switch")) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        d.Q(z);
                        if (cursor.getInt(cursor.getColumnIndex("reply_me_switch")) == 0) {
                            se5.d().R(false);
                        } else {
                            se5.d().R(true);
                        }
                        if (cursor.getInt(cursor.getColumnIndex("at_me_switch")) == 0) {
                            se5.d().M(false);
                        } else {
                            se5.d().M(true);
                        }
                        if (cursor.getInt(cursor.getColumnIndex("zan_me_switch")) == 0) {
                            se5.d().U(false);
                        } else {
                            se5.d().U(true);
                        }
                        se5.d().a(cursor.getInt(cursor.getColumnIndex("remind_tone")));
                        if (cursor.getInt(cursor.getColumnIndex("msg_chat_switch")) == 0) {
                            se5.d().N(false);
                        } else {
                            se5.d().N(true);
                        }
                        if (cursor.getInt(cursor.getColumnIndex("nodisturb_switch")) == 0) {
                            se5.d().W(false);
                        } else {
                            se5.d().W(true);
                        }
                        se5.d().X(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        se5.d().V(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                        if (cursor.getInt(cursor.getColumnIndex("remind_light")) == 0) {
                            se5.d().P(false);
                        } else {
                            se5.d().P(true);
                        }
                        if (cursor.getInt(cursor.getColumnIndex("stranger_chat_switch")) == 0) {
                            se5.d().d0(false);
                        } else {
                            se5.d().d0(true);
                        }
                    } else {
                        se5.d().O(300);
                        se5.d().Q(true);
                        se5.d().R(true);
                        se5.d().M(true);
                        se5.d().U(true);
                        se5.d().S(true);
                        se5.d().T(false);
                        se5.d().P(true);
                        se5.d().d0(false);
                        se5.d().N(true);
                        se5.d().W(false);
                        se5.d().X(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        se5.d().V(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    }
                    se5.d().K(r95.p().l("GroupChatPushOn", true));
                } catch (Exception e) {
                    mainDBDatabaseManager.i(e, "getSettingData");
                }
                ug.a(cursor);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001311));
            } catch (Throwable th) {
                ug.a(null);
                throw th;
            }
        }
    }

    public static void p(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, null, i, str) == null) {
            t9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null) {
                if (i != 0) {
                    if (i == 1) {
                        mainDBDatabaseManager.e("delete from search_post_data where key=?", new String[]{str});
                        mainDBDatabaseManager.e("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                        return;
                    }
                    return;
                }
                mainDBDatabaseManager.e("delete from search_data where key=?", new String[]{str});
                mainDBDatabaseManager.e("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
            }
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65554, null) != null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        t9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
        mainDBDatabaseManager.e("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{TbadkCoreApplication.getCurrentAccount(), Integer.valueOf(se5.d().f()), Integer.valueOf(se5.d().y() ? 1 : 0), Integer.valueOf(se5.d().A() ? 1 : 0), Integer.valueOf(se5.d().v() ? 1 : 0), Integer.valueOf(se5.d().c()), Integer.valueOf(se5.d().w() ? 1 : 0), Integer.valueOf(se5.d().E() ? 1 : 0), se5.d().h(), se5.d().g(), Integer.valueOf(se5.d().x() ? 1 : 0), Integer.valueOf(se5.d().G() ? 1 : 0), Integer.valueOf(se5.d().D() ? 1 : 0)});
        r95.p().A("GroupChatPushOn", se5.d().t());
    }
}
