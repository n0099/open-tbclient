package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rfa {
    public static /* synthetic */ Interceptable $ic;
    public static final double[] a;
    public static final double[] b;
    public static final double[] c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948121084, "Lcom/baidu/tieba/rfa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948121084, "Lcom/baidu/tieba/rfa;");
                return;
            }
        }
        a = new double[]{8.524682068201687E-11d, 2.5966600546497407E-9d, 7.968999456864018E-8d, 1.990671040966775E-6d, 4.0312469446528E-5d, 6.449987160622426E-4d, 0.007901234576193059d, 0.07111111110920705d, 0.4444444444447249d, 1.7777777777777533d, 4.000000000000001d, 4.0d, 1.0d, 1.1520919130377196E-10d, 2.2287613013610985E-9d, 8.190395193069459E-8d, 1.9821560631611546E-6d, 4.033546194091013E-5d, 6.449533097443221E-4d, 0.007901301261146751d, 0.07111103816087556d, 0.444444503190627d, 1.777777743914645d, 4.000000013233794d, 3.9999999968569013d, 1.0000000003426703d, 1.547687078051524E-10d, 1.2685004214732975E-9d, 9.277686185111423E-8d, 1.9063070109379044E-6d, 4.069800438991794E-5d, 6.437044724429807E-4d, 0.007904474945844498d, 0.07110505241174936d, 0.44445280640924756d, 1.777769493443211d, 4.000005580882401d, 3.9999977081165743d, 1.000000433394932d, 2.0675200625006794E-10d, -6.168955470512568E-10d, 1.243676591540157E-7d, 1.5830429403520612E-6d, 4.2947227560776585E-5d, 6.324986166507344E-4d, 0.007945447284095393d, 0.07099432778566186d, 0.44467219586283d, 1.7774588182255375d, 4.000303898625272d, 3.9998233869142057d, 1.0000472932961288d, 2.747568479498271E-10d, -3.899147207652133E-9d, 1.973017048397605E-7d, 5.965153156196767E-7d, 5.199297147474899E-5d, 5.732733867543377E-4d, 0.008229314383653041d, 0.06999093485872804d, 0.44726764292723986d, 1.7726685170014087d, 4.00629078637127d, 3.9952750700487845d, 1.001635434665418d};
        b = new double[]{6.785236714494553E-8d, 4.6266061382821827E-7d, 6.970313581235407E-6d, 7.663766346295323E-5d, 7.911351522261269E-4d, 0.007340120473110381d, 0.060677114958668836d, 0.43994941411651567d, 2.742001709766175d, 14.28966192174086d, 59.82060964032071d, 188.7899868119915d, 399.8731367825601d, 427.5641157218048d, 1.8042097874891098E-7d, 1.2277164312044637E-6d, 1.8484393221474274E-5d, 2.029399590009131E-4d, 0.0020918539850246208d, 0.01937531565403395d, 0.15985869016767185d, 1.1565260527420642d, 7.189634122420607d, 37.35477381194748d, 155.8099316426627d, 489.5211371158541d, 1030.9147225169565d, 1093.5883545113747d, 4.801730561318749E-7d, 3.26131784391238E-6d, 4.907313750816616E-5d, 5.380650667648759E-4d, 0.005538791829105187d, 0.05122371748878655d, 0.42190298621367917d, 3.0463625987357354d, 18.895299447327734d, 97.91518902945546d, 407.13940115493494d, 1274.3088990480583d, 2670.9883037012546d, 2815.7166284662544d, 1.2789926338424624E-6d, 8.671826306760492E-6d, 1.304150882129993E-4d, 0.0014282247373727478d, 0.014684070635768789d, 0.13561403190404187d, 1.1152592585977394d, 8.038708855946538d, 49.76131889589548d, 257.2684232313529d, 1066.8543146269567d, 3328.3874581009636d, 6948.858659812164d, 7288.489339821248d, 3.409350368197033E-6d, 2.3079025203103375E-5d, 3.4691373283901833E-4d, 0.0037949949772229084d, 0.038974209677945605d, 0.35949483804148785d, 2.952287889353953d, 21.246564609514287d, 131.28727387146174d, 677.3810709329667d, 2802.3724744545048d, 8718.573142079826d, 18141.348781638833d, 18948.925349296307d};
        c = new double[]{2.5568678676452704E-15d, 3.039395379230592E-14d, 6.334375199109483E-13d, 1.504129801183301E-11d, 4.4569436918556543E-10d, 1.746393051427168E-8d, 1.0059224011079853E-6d, 1.0729838945088577E-4d, 0.05150322693642528d, 5.252796399171156E-15d, 7.202118481421006E-15d, 7.25614212299048E-13d, 1.4823121466731044E-11d, 4.4602670450376247E-10d, 1.746360006178868E-8d, 1.0059226091322347E-6d, 1.0729838937545111E-4d, 0.0515032269364373d, 1.336591735935807E-14d, -1.2932643065888545E-13d, 1.7450199447905602E-12d, 1.041905120905698E-11d, 4.580478819805983E-10d, 1.744240545007355E-8d, 1.0059461453281293E-6d, 1.0729837434500161E-4d, 0.051503226940658446d, 5.3771611477352306E-14d, -1.139619300641373E-12d, 1.2858641335221653E-11d, -5.980208600457006E-11d, 7.366689430592951E-10d, 1.6731837150730355E-8d, 1.0070831435812128E-6d, 1.0729733111203705E-4d, 0.051503227360726295d, 3.781949208485893E-14d, -4.860049688858804E-13d, 1.6898350504817224E-12d, 4.588462432752426E-11d, 1.2521615963377513E-10d, 1.895965843775473E-8d, 1.0020716710561354E-6d, 1.0730371198569276E-4d, 0.05150322383300231d};
    }

    public static double a(double d) {
        InterceptResult invokeCommon;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d)})) == null) {
            double abs = Math.abs(d);
            if (abs < 8.5d) {
                double d4 = abs * abs * 0.0625d;
                int i = ((int) d4) * 13;
                double[] dArr = a;
                d2 = ((((((((((((((((((((((dArr[i] * d4) + dArr[i + 1]) * d4) + dArr[i + 2]) * d4) + dArr[i + 3]) * d4) + dArr[i + 4]) * d4) + dArr[i + 5]) * d4) + dArr[i + 6]) * d4) + dArr[i + 7]) * d4) + dArr[i + 8]) * d4) + dArr[i + 9]) * d4) + dArr[i + 10]) * d4) + dArr[i + 11]) * d4;
                d3 = dArr[i + 12];
            } else if (abs < 12.5d) {
                int i2 = (int) abs;
                double d5 = abs - i2;
                int i3 = (i2 - 8) * 14;
                double[] dArr2 = b;
                d2 = ((((((((((((((((((((((((dArr2[i3] * d5) + dArr2[i3 + 1]) * d5) + dArr2[i3 + 2]) * d5) + dArr2[i3 + 3]) * d5) + dArr2[i3 + 4]) * d5) + dArr2[i3 + 5]) * d5) + dArr2[i3 + 6]) * d5) + dArr2[i3 + 7]) * d5) + dArr2[i3 + 8]) * d5) + dArr2[i3 + 9]) * d5) + dArr2[i3 + 10]) * d5) + dArr2[i3 + 11]) * d5) + dArr2[i3 + 12]) * d5;
                d3 = dArr2[i3 + 13];
            } else {
                double d6 = 60.0d / abs;
                int i4 = ((int) d6) * 9;
                double[] dArr3 = c;
                return ((((((((((((((((dArr3[i4] * d6) + dArr3[i4 + 1]) * d6) + dArr3[i4 + 2]) * d6) + dArr3[i4 + 3]) * d6) + dArr3[i4 + 4]) * d6) + dArr3[i4 + 5]) * d6) + dArr3[i4 + 6]) * d6) + dArr3[i4 + 7]) * d6) + dArr3[i4 + 8]) * Math.sqrt(d6) * Math.exp(abs);
            }
            return d2 + d3;
        }
        return invokeCommon.doubleValue;
    }
}
